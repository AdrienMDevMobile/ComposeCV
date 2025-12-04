package com.adrienmandroid.composecv.feature.other.ui.elements.quote

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun QuoteLoading(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.padding(margin),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            color = MaterialTheme.colors.secondary,
        )
    }
}