sharedProjectData.main_cls = "$group.VotingClient"

setupShadowJar()

dependencies {
    compileOnly(Dependencies.LOMBOK)
    annotationProcessor(Dependencies.LOMBOK)
    compileOnly(Dependencies.GUICE)
}