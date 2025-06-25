plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.compose)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.adrienmandroid.composecv.core.test"
}