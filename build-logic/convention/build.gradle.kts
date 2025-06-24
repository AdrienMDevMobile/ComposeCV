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
            id = "com.adrienmandroid.composecv.application"
            implementationClass = "ApplicationConventionPlugin"
        }
        register("library") {
            id = "com.adrienmandroid.composecv.library"
            implementationClass = "LibraryConventionPlugin"
        }
        register("libraryCompose") {
            id = "com.adrienmandroid.composecv.library.compose"
            implementationClass = "LibraryComposeConventionPlugin"
        }
        register("hilt") {
            id = libs.plugins.convention.library.hilt.get().pluginId
            implementationClass = "HiltConventionPlugin"
        }
    }
}