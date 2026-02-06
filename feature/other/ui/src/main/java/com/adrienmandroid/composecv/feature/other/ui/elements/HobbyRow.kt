package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.ui.preview.data.HobbyPreviewParameterData
import com.adrienmandroid.composecv.feature.other.ui.state.HobbyUiState

@Composable
fun HobbyRow(hobbies: List<HobbyUiState>) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 12.dp)
    ) {
        items(items = hobbies) {
            HobbyCardView(it)
        }
    }
}

@Composable
@PreviewLightDark
fun PreviewHobbyRow() {
    ComposeCVTheme {
        HobbyRow(HobbyPreviewParameterData().hobbies.hobbies)
    }
}