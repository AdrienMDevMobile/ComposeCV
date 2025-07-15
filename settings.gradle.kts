pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ComposeCV"
include(":app")
include(":core:data")
include(":core:model")
include(":core:test")
include(":core:ui")
include(":feature:welcome:ui")
include(":feature:skills")
include(":feature:experience")
include(":feature:other")
include(":feature:other:ui")
include(":feature:experience:ui")
