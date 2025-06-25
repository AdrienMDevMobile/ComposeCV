import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import convention.libs
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
/*
class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager){
                apply("com.google.devtools.ksp")
            }

            extensions.configure<ApplicationExtension> {
                dependencies {
                    add("ksp", libs.findLibrary("hilt.compiler").get())
                }
            }

/*
            // Add support for Jvm Module, base on org.jetbrains.kotlin.jvm
            pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
                dependencies {
                    "implementation"(libs.findLibrary("hilt.core").get())
                }
            }

            /** Add support for Android modules, based on [AndroidBasePlugin] */
            pluginManager.withPlugin("com.android.base") {
                apply(plugin = "dagger.hilt.android.plugin")
                dependencies {
                    "implementation"(libs.findLibrary("hilt.android").get())
                }
            }*/
        }
    }
}*/
