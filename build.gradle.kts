allprojects {
    extensions.create("sharedProjectData", SharedProjectData::class.java)
}

plugins {
    id("java")
}

subprojects {
    apply {
        plugin<JavaPlugin>()
    }

    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://jitpack.io")
    }
}