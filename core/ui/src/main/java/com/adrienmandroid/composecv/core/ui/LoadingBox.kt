package com.adrienmandroid.composecv.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImagePainter

@Composable
fun LoadingBox(
    isLoading: Boolean,
    isError: Boolean,
    isLocalInspection: Boolean,
    imageLoader: AsyncImagePainter,
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    loadingModifier: Modifier = Modifier,
    placeholderPainter: Painter = painterResource(R.drawable.core_placeholder),
    contentDescription: String = "@null"
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = imageModifier,
            contentScale = ContentScale.Crop,
            painter = if (isError.not() && !isLocalInspection) {
                imageLoader
            } else {
                placeholderPainter
            },
            contentDescription = contentDescription,
        )

        if (isLoading) {
            CircularProgressIndicator(
                modifier = loadingModifier,
                color = MaterialTheme.colors.secondary,
            )
        }
    }
}