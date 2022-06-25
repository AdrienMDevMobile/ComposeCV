package com.adrienmandroid.composecv.ui.welcome

import androidx.compose.runtime.Composable
import com.adrienmandroid.composecv.ui.nav.intents.ClickViewModel

interface SimpleDraw {
    @Composable
    fun Draw(clickViewModel: ClickViewModel)
}