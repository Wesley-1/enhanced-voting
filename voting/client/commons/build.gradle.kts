import Dependencies.GUICE
import Dependencies.LOMBOK
import Dependencies.SELENIUM

sharedProjectData.main_cls = "$group.VotingClient"

setupShadowJar()

dependencies {
    compileOnly(LOMBOK)
    annotationProcessor(LOMBOK)
    compileOnly(GUICE)
    compileOnly(SELENIUM)
}