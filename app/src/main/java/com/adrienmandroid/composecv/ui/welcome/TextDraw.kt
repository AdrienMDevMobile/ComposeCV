package com.adrienmandroid.composecv.ui.welcome

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

class TextDraw(val id: Int, val args : Array<Any> = emptyArray()) : SimpleDrawable {
    @Composable
    override fun draw() {
        Text(stringResource(id, *args))
    }

}