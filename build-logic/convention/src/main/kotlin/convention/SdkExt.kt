package convention

import com.android.build.api.dsl.CommonExtension

internal fun configureSdk(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
){
    commonExtension.apply {
        compileSdk = 35

        defaultConfig {
            minSdk = 24
        }
    }
}