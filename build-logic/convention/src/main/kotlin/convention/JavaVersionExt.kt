package convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion

fun configureJvmCompile(
    //Paramètre obligatoire pour y appliquer nos changements
    commonExtension: CommonExtension,
){
    commonExtension.apply {
        compileOptions.sourceCompatibility = JavaVersion.VERSION_21
        compileOptions.targetCompatibility = JavaVersion.VERSION_21
    }
}