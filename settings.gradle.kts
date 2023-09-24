pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

rootProject.name = "Chevit"
include(":app")
include(":core")
include(":domain")
include(":data")
include(":presentation:common")
include(":presentation:deeplink")
include(":presentation:auth")
include(":presentation:home")
include(":presentation:splash")
include(":presentation:resource")
include(":presentation:step")
include(":presentation:checklist")
