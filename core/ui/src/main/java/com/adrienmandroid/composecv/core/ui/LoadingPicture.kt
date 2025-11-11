package com.adrienmandroid.composecv.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.allowHardware
import coil3.request.crossfade

//help from : https://medium.com/@ramadan123sayed/migrating-from-coil-2-x-to-coil-3-x-in-jetpack-compose-complete-migration-guide-e387962e90d8
@Composable
fun SelfLoadingPicture(
    pictureUrl: String,
    modifier: Modifier = Modifier,
    imageModifier: Modifier = Modifier,
    loadingModifier: Modifier = Modifier,
    placeholderPainter: Painter = painterResource(R.drawable.core_placeholder),
    contentDescription: String = "@null",
    colorFilter: ColorFilter? = null,
) {
    val context = LocalPlatformContext.current

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(context)
                .data(pictureUrl)
                .crossfade(true)
                .memoryCachePolicy(CachePolicy.ENABLED)
                .diskCachePolicy(CachePolicy.ENABLED)
                .allowHardware(false) // Better compatibility
                .build(),
            contentDescription = contentDescription,
            modifier = imageModifier,
            success = { successState ->
                Image(
                    painter = successState.painter,
                    contentDescription = contentDescription,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    colorFilter = colorFilter,
                )
            },
            loading = {
                CircularProgressIndicator(modifier = loadingModifier)
            },
            error = {
                Image(
                    placeholderPainter,
                    contentDescription = "placeholder",
                    modifier = imageModifier,
                )
            }
        )
    }
}