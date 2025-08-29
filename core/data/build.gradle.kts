plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.convention.hilt.library)
}

android {
    namespace = "com.adrienmandroid.composecv.data"
}

dependencies {
    api(project(":core:model"))

    implementation(libs.androidx.lifecycle.livedata.ktx)
}