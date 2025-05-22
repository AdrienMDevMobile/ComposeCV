plugins {
    alias(libs.plugins.convention.library)
    alias(libs.plugins.convention.library.compose)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.adrienmandroid.composecv.feature.other"

    /*
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