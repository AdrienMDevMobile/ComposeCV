plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.hilt.library)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.welcome.domain"
}

dependencies {
    implementation(project(":core:model"))
}