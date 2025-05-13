package convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

internal fun Project.configureSdk(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
){
    commonExtension.apply {
        compileSdk = 35

        defaultConfig {
            minSdk = 24
        }
    }
}