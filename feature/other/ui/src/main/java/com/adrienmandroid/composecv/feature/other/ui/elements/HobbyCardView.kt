package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.SelfLoadingPicture
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.ui.state.HobbyUiState

val hobby_width = 200.dp

@Composable
fun HobbyCardView(hobby: HobbyUiState) {
    Column(
        modifier = Modifier
            .semantics(mergeDescendants = true) {}
            .size(width = hobby_width, height = 250.dp)
            .padding(horizontal = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SelfLoadingPicture(
            pictureUrl = hobby.pictureUrl,
            contentDescription = null,
            modifier = Modifier
                .size(hobby_width, hobby_width),
            imageModifier = Modifier.fillMaxSize()
        )
        Text(
            text = hobby.name,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 5.dp)
        )
        Text(
            text = hobby.category,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}

@Composable
@PreviewLightDark
fun PreviewHobbyCardView() {
    ComposeCVTheme {
        HobbyCardView(
            hobby = HobbyUiState(
                name = "Name hobby",
                pictureUrl = "",
                category = "Category hobby"
            )
        )
    }
}