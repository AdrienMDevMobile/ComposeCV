package convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }
        dependencies {

            val composeBom = libs.findLibrary("android.compose.bom").get()
            add("implementation", platform(composeBom))
            add("implementation", libs.findLibrary("accompanist.flowlayout").get())
            add("implementation", libs.findLibrary("android.activity.compose").get())
            add("implementation", libs.findLibrary("android.compose.material").get())
            add("implementation", libs.findLibrary("android.compose.preview").get())
            add("implementation", libs.findLibrary("android.compose.runtime").get())
            add("implementation", libs.findLibrary("android.compose.ui").get())
            add("implementation", libs.findLibrary("android.compose.viewmodel").get())
            add("implementation", libs.findLibrary("android.constraintlayout").get())
            add("implementation", libs.findLibrary("android.constraintlayout.compose").get())
            add("implementation", libs.findLibrary("android.navigation.compose").get())
            add("implementation", libs.findLibrary("google.accompanist.pager").get())
            add("implementation", libs.findLibrary("google.accompanist.pager.indicators").get())

            add("androidTestImplementation", platform(composeBom))
            add("androidTestImplementation", libs.findLibrary("android.compose.junit").get())

            add("debugImplementation", libs.findLibrary("android.compose.ui.tooling").get())
        }
    }
}
