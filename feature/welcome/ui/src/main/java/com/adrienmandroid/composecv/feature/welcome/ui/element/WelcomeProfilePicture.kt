package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.adrienmandroid.composecv.core.ui.SelfLoadingPicture
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme

@Composable
fun WelcomeProfilePicture(
    welcomeImageUrl: String
) {
    SelfLoadingPicture(
        pictureUrl = welcomeImageUrl,
        modifier = Modifier
            .size(140.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colors.background)
            .zIndex(1f),
        imageModifier = Modifier
            .size(128.dp)
            .clip(CircleShape),
        loadingModifier = Modifier.size(80.dp),
        contentDescription = "Picture"
    )
}

@Composable
@PreviewLightDark
fun PreviewWelcomeProfilePicture() {
    ComposeCVTheme {
        WelcomeProfilePicture("")
    }
}