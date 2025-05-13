import com.android.build.api.dsl.ApplicationExtension
import convention.configureCompose
import convention.configureSdk
import convention.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class ApplicationConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<ApplicationExtension> {
                configureSdk(this)
                defaultConfig.targetSdk = 35

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_21
                    targetCompatibility = JavaVersion.VERSION_21
                }

                extensions.configure<JavaPluginExtension> {
                    sourceCompatibility = JavaVersion.VERSION_21
                    targetCompatibility = JavaVersion.VERSION_21
                }

                configure<KotlinAndroidProjectExtension> {
                    with(compilerOptions) {
                        jvmTarget.set(JvmTarget.JVM_21)
                    }
                }

                configureCompose(this)
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