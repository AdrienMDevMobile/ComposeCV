package com.adrienmandroid.composecv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme
import com.adrienmandroid.composerandom.MainScreen

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