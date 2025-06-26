import com.android.build.gradle.LibraryExtension
import convention.configureHiltExtensionsForLibrary
import convention.configureHiltPlugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class LibraryHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureHiltPlugins(pluginManager)

            extensions.configure<LibraryExtension> {
                configureHiltExtensionsForLibrary(this)
            }
        }
    }
}
