import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `kotlin-dsl`
}

group = "com.adrienmandroid.composecv.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_21
    }
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

dependencies {
    compileOnly(libs.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("application") {
            id = libs.plugins.convention.application.get().pluginId
            implementationClass = "ApplicationConventionPlugin"
        }
        register("library") {
            id = libs.plugins.convention.library.get().pluginId
            implementationClass = "LibraryConventionPlugin"
        }
        register("libraryCompose") {
            id = libs.plugins.convention.compose.library.get().pluginId
            implementationClass = "LibraryComposeConventionPlugin"
        }
        register("hilt") {
            id = libs.plugins.convention.hilt.library.get().pluginId
            implementationClass = "LibraryHiltConventionPlugin"
        }
        register("json") {
            id = libs.plugins.convention.json.library.get().pluginId
            implementationClass = "LibraryJsonPlugin"
        }
        register("room") {
            id = libs.plugins.convention.room.library.get().pluginId
            implementationClass = "LibraryRoomPlugin"
        }
    }
}