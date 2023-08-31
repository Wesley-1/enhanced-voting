import Dependencies.GUICE
import Dependencies.LOMBOK
import Dependencies.SELENIUM
import Dependencies.SPRING

sharedProjectData.main_cls = "$group.VotingClient"

setupShadowJar()

dependencies {
    compileOnly(LOMBOK)
    annotationProcessor(LOMBOK)
    compileOnly(GUICE)
    implementation(SELENIUM)
   // implementation(SPRING)
}