package convention

import com.android.build.api.dsl.CommonExtension

internal fun configureSdk(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
){
    commonExtension.apply {
        compileSdk = 36

        defaultConfig {
            minSdk = 28
        }
    }
}