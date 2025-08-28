import convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class LibraryJsonPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            dependencies {
                add("implementation", libs.findLibrary("moshi").get())
                add("implementation", libs.findLibrary("moshi.kotlin").get())
            }
        }
    }
}