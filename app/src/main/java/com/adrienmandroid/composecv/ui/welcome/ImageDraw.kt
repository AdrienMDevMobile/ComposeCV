package com.adrienmandroid.composecv.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class ImageDraw(val source : Int, val description : String) : SimpleDrawable{
    @Composable
    override fun draw() {
        Image(
            painter = painterResource(source),
            contentDescription = description,
            modifier = Modifier.size(50.dp, 50.dp)
        )
    }
}