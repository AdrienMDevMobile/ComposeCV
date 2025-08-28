plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.compose.library)
    alias(libs.plugins.convention.hilt.library)
    alias(libs.plugins.convention.json.library)
    alias(libs.plugins.convention.room.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.skills.data"
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    implementation(project(":feature:skills:domain"))
}