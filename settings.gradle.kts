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
include(":feature:experience:data")
include(":feature:experience:domain")
include(":feature:experience:ui")
include(":feature:other:data")
include(":feature:other:domain")
include(":feature:other:ui")
include(":feature:skills:data")
include(":feature:skills:domain")
include(":feature:skills:ui")
include(":feature:welcome:data")
include(":feature:welcome:domain")
include(":feature:welcome:ui")