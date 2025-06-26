import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import convention.libs
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class LibraryHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager){
                apply("com.google.devtools.ksp")
                apply("com.google.dagger.hilt.android")
            }

            extensions.configure<LibraryExtension> {
                dependencies {
                    add("implementation", libs.findLibrary("hilt.android").get())
                    add("implementation", libs.findLibrary("hilt.navigation.compose").get())
                    add("ksp", libs.findLibrary("hilt.compiler").get())
                }
            }
        }
    }
}
