import com.android.build.api.dsl.ApplicationExtension
import convention.configureComposeExtension
import convention.configureComposePlugin
import convention.configureHiltExtensionsForApplication
import convention.configureHiltPlugins
import convention.configureJavaExtension
import convention.configureJvmCompile
import convention.configureSdk
import convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class ApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            configureComposePlugin(pluginManager)
            configureHiltPlugins(pluginManager)

            extensions.configure<ApplicationExtension> {
                configureSdk(this)
                defaultConfig.targetSdk = 35

                configureJvmCompile(this)

                configureJavaExtension(this)

                configureComposeExtension(this)

                configureHiltExtensionsForApplication(this)

                dependencies {
                    add("implementation", libs.findLibrary("android.core.ktx").get())
                    add("implementation", libs.findLibrary("android.lifecycle.runtime").get())
                    add("testImplementation", libs.findLibrary("test.junit").get())
                    add("androidTestImplementation", libs.findLibrary("android.test.junit").get())
                    add("androidTestImplementation", libs.findLibrary("android.test.espresso").get())
                }
            }
        }
    }
}