package com.adrienmandroid.composecv.ui.welcome

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

class TextDraw(private val id: Int, private val args: Array<Any> = emptyArray()) : SimpleDraw {
    @Composable
    override fun Draw() {
        Text(stringResource(id, *args))
    }

}