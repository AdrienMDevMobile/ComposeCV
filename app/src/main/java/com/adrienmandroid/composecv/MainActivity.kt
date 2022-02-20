package com.adrienmandroid.composecv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme
import com.adrienmandroid.composerandom.MainScreen

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCVTheme {
                MainScreen()
            }
        }
    }
}