package convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.dependencies

internal fun configureHiltPlugins(
    pluginManager: PluginManager,
) {
    with(pluginManager){
        apply("com.google.devtools.ksp")
        apply("com.google.dagger.hilt.android")
    }
}

internal fun Project.configureHiltExtensionsForApplication(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
){
    configureHiltExtensions(commonExtension, false)
}

internal fun Project.configureHiltExtensionsForLibrary(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
){
    configureHiltExtensions(commonExtension, true)
}

private fun Project.configureHiltExtensions(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    requiresNavigationCompose: Boolean,
){
    commonExtension.apply {
        dependencies {
            add("implementation", libs.findLibrary("hilt.android").get())
            if(requiresNavigationCompose) {
                add("implementation", libs.findLibrary("hilt.navigation.compose").get())
            }
            add("ksp", libs.findLibrary("hilt.compiler").get())
        }
    }
}