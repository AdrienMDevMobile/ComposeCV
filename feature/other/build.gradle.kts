plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.compose.library)
    alias(libs.plugins.convention.hilt.library)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.other"

    /*TODO
    buildFeatures {
        //Necessaire pour afficher le numéro de version dans l'app
        buildConfig(true)
    }*/
}

dependencies {
    implementation(project(":core:data"))
    implementation(project(":core:ui"))
    debugImplementation(project(":core:test"))
}