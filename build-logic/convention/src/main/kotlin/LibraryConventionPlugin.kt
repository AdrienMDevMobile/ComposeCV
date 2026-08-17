import com.android.build.api.dsl.LibraryExtension
import convention.configureJvmCompile
import convention.configureSdk
import convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class LibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }

            extensions.configure<LibraryExtension> {
                configureSdk(this)

                configureJvmCompile(this)
                defaultConfig.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                dependencies {
                    add("implementation", libs.findLibrary("android.core.ktx").get())
                }
            }
        }
    }
}