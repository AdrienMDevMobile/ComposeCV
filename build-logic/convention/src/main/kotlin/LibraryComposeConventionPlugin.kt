import com.android.build.gradle.LibraryExtension
import convention.configureComposeExtension
import convention.configureComposePlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class LibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureComposePlugin(pluginManager)
            extensions.configure<LibraryExtension> {
                configureComposeExtension(this)
            }
        }
    }
}