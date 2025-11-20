import convention.configureRetrofit
import org.gradle.api.Plugin
import org.gradle.api.Project

class LibraryRetrofitCorePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureRetrofit()
        }
    }
}