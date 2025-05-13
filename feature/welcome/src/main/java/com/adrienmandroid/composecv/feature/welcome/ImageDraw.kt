package com.adrienmandroid.composecv.domain.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun ImageDraw(source: Int, description: String, tint: Boolean = false) {
    Image(
        painter = painterResource(source),
        contentDescription = description,
        modifier = Modifier.size(80.dp, 80.dp),
        colorFilter = if (tint) {
            ColorFilter.tint(MaterialTheme.colors.onBackground)
        } else {
            null
        }
    )
}