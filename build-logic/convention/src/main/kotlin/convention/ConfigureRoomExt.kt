package convention

// buildSrc/src/main/kotlin/ConfigureRoomExt.kt
// Ou dans votre module de convention (ex: build-logic/convention/src/main/kotlin/ConfigureRoomExt.kt)

import convention.libs
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import java.io.File

/**
 * Configure Room dependencies and compiler options for a project.
 */
fun Project.configureRoom() {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    dependencies {
        "implementation"(libs.findLibrary("androidx.room.runtime").get())
        "implementation"(libs.findLibrary("androidx.room.ktx").get()) // Pour les extensions Kotlin et Coroutines
        "ksp"(libs.findLibrary("androidx.room.compiler").get())
    }
}