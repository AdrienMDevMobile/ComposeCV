plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.adrienmandroid.composecv.data"
}

dependencies {

    api(project(":core:model"))
}