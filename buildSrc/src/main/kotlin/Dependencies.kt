// Contains all version information for out dependencies.
object Versions {
    const val LOMBOK_VERSION = "1.18.20"
    const val REFLECTIONS_VERSION = "0.10.2";
    const val GUICE_VERSION = "5.1.0"
    const val ORMLITE_VERSION = "6.1"
    const val JUPITER_VERSION = "5.9.3"
    const val JAKARTA_VER = "4.0.0"
    const val APACHE_VER = "4.5.13"
    const val SHELFTOR_VER = "0.2"
    const val BINDABLES_VER = "v0.2"
    const val SELENIUM_VER = "3.+"
}

object Dependencies {
    const val LOMBOK = "org.projectlombok:lombok:${Versions.LOMBOK_VERSION}"
    const val REFLECTIONS = "org.reflections:reflections:${Versions.REFLECTIONS_VERSION}"
    const val GUICE = "com.google.inject:guice:${Versions.GUICE_VERSION}"
    const val ORMLITE_CORE = "com.j256.ormlite:ormlite-core:${Versions.ORMLITE_VERSION}"
    const val ORMLITE_JDBC = "com.j256.ormlite:ormlite-jdbc:${Versions.ORMLITE_VERSION}"
    const val JUNIT = "org.junit.jupiter:junit-jupiter:${Versions.JUPITER_VERSION}"
    const val JAKARTA = "jakarta.xml.bind:jakarta.xml.bind-api:${Versions.JAKARTA_VER}"
    const val APACHE_HTTP = "org.apache.httpcomponents:httpmime:${Versions.APACHE_VER}"
    const val SHELFTOR = "dev.oop778.shelftor:shelftor-core:${Versions.SHELFTOR_VER}"
    const val SELENIUM = "org.seleniumhq.selenium:selenium-java:${Versions.SELENIUM_VER}"
}