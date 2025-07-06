package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme

@Composable
fun Gratitudes(gratitude: String) {
    Text(
        text = gratitude,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.body1
    )
}

@Preview
@Composable
fun PreviewGratitudes() {
    ComposeCVTheme {
        Gratitudes(
            LoremIpsum(words = 50).values.toList().joinToString(separator = " "),
        )
    }
}