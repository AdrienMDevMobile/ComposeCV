import convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

//TODO remove moshi once all data class only use retrofit
class LibraryJsonPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            dependencies {
                add("implementation", libs.findLibrary("squareup.retrofit").get())
                add("implementation", libs.findLibrary("moshi").get())
                add("implementation", libs.findLibrary("moshi.kotlin").get())
                add("implementation", libs.findLibrary("kotlin.serialization.converter").get())
                add("implementation", libs.findLibrary("kotlin.serialization.json").get())
            }
        }
    }
}