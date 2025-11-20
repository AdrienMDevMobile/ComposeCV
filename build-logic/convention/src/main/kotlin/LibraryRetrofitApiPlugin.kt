import convention.configureRetrofit
import org.gradle.api.Plugin
import org.gradle.api.Project

class LibraryRetrofitApiPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureRetrofit()

            with(pluginManager) {
                apply("org.jetbrains.kotlin.plugin.serialization")
            }
        }
    }
}