package com.adrienmandroid.composecv.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.ui.nav.intents.ClickViewModel

class ImageDraw(private val source: Int, private val description: String) : SimpleDraw {
    @Composable
    override fun Draw(clickViewModel: ClickViewModel) {
        Image(
            painter = painterResource(source),
            contentDescription = description,
            modifier = Modifier.size(80.dp, 80.dp)
        )
    }
}