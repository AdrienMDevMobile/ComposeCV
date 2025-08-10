package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.SelfLoadingPicture

@Composable
fun WelcomeBackgroundPicture(welcomeImageUrl: String) {
    SelfLoadingPicture(
        pictureUrl = welcomeImageUrl,
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        imageModifier = Modifier.fillMaxSize(),
        loadingModifier = Modifier.size(80.dp)
    )
}