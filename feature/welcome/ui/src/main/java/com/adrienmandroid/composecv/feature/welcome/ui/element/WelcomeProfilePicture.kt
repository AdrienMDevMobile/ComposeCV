package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.adrienmandroid.composecv.core.ui.LoadingPicture

@Composable
fun WelcomeProfilePicture(
    welcomeImageUrl: String
) {
    LoadingPicture(
        pictureUrl = welcomeImageUrl,
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .padding(5.dp)
            .zIndex(1f)
            .clip(CircleShape)
            .border(4.dp, MaterialTheme.colors.background, CircleShape),
        //TODO
        contentDescription = "Picture"
    )
}