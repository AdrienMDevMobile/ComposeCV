package convention

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.configureRetrofit() {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    dependencies {
        "implementation"(libs.findLibrary("squareup.retrofit").get())
        "implementation"(libs.findLibrary("kotlin.serialization.converter").get())
        add("implementation", libs.findLibrary("kotlin.serialization.json").get())
    }
}