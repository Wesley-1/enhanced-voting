import com.github.jengelman.gradle.plugins.shadow.ShadowPlugin
import com.github.jengelman.gradle.plugins.shadow.tasks.ConfigureShadowRelocation
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.testing.Test
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.*
import org.gradle.language.jvm.tasks.ProcessResources

fun Project.setupShadowJar(fat: Boolean = false) {
    apply<ShadowPlugin>()

    tasks {
        register<ConfigureShadowRelocation>("relocate") {
            target = withType(ShadowJar::class).getByName("shadowJar")

            val arr = project.group.toString().split(".")
            prefix = arr.subList(0, arr.size - 1).joinToString(".") + ".shade"

            doLast {
                synchronized(System.out) {
                    println(">> Relocating shaded packages to $prefix.*")
                }
            }
        }

        withType<ShadowJar> {
            if(System.getProperty("relocate") != null)//run with "-Drelocate" (jvm arg) to relocate for release, but don't do it for debug since it breaks hot-swap and takes longer
                dependsOn(getByName("relocate"))
            archiveFileName.set(project.name + ".jar")
            if(!fat)
                exclude("kotlin/**")
            val shared = project.extensions.getByType(SharedProjectData::class.java)
            if(shared.main_cls != null)
                manifest {
                    attributes(mapOf("Main-Class" to shared.main_cls))
                }
        }

        getByName("build") {
            dependsOn(withType<ShadowJar>())
        }
    }
}

private fun ShadowJar.relocate(group: Any, vararg dependencies: String) {
    dependencies.forEach {
        val split = it.split(".")
        val name = split.last()
        relocate(it, "$group.dependencies.$name")
    }
}

fun Project.setupKotlin() {
    apply {
        plugin("kotlin")
    }

    tasks {
        tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
}

fun Project.setupJUnit() {
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}