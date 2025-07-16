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
include(":feature:welcome:domain")
include(":feature:skills:ui")
include(":feature:skills:domain")
include(":feature:experience:ui")
include(":feature:experience:domain")
include(":feature:other:ui")
include(":feature:other:domain")

include(":feature:welcome:data")
include(":feature:experience:data")
