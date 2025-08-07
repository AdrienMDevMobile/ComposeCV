package com.adrienmandroid.composecv.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.isPopupLayout
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter

@Composable
fun SelfLoadingPicture(
    pictureUrl: String,
    modifier: Modifier = Modifier,
    imageModifier: Modifier = modifier,
    loadingModifier: Modifier = Modifier,
    placeholderPainter: Painter = painterResource(R.drawable.core_placeholder),
    contentDescription: String = "@null",
) {
    var isLoading by remember { mutableStateOf(true) }
    var isError by remember { mutableStateOf(false) }
    val imageLoader = rememberAsyncImagePainter(
        model = pictureUrl,
        onState = { state ->
            isLoading = state is AsyncImagePainter.State.Loading
            isError = state is AsyncImagePainter.State.Error
        },
    )
    val isLocalInspection = LocalInspectionMode.current

    LoadingBox(
        isLoading = isLoading,
        isError = isError,
        isLocalInspection = isLocalInspection,
        imageLoader = imageLoader,
        modifier = modifier,
        imageModifier = imageModifier,
        loadingModifier = loadingModifier,
        placeholderPainter = placeholderPainter,
        contentDescription = contentDescription
    )

}