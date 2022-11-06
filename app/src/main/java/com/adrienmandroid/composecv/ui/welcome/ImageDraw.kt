package com.adrienmandroid.composecv.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun ImageDraw(source: Int, description: String) {
    Image(
        painter = painterResource(source),
        contentDescription = description,
        modifier = Modifier.size(80.dp, 80.dp)
    )
}