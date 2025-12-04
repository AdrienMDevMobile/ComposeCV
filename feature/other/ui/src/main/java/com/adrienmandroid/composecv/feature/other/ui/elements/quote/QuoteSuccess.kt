package com.adrienmandroid.composecv.feature.other.ui.elements.quote

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.adrienmandroid.composecv.feature.other.ui.state.QuoteUiState
import com.adrienmandroid.composecv.feature.other.ui.state.TextPosition

@Composable
fun QuoteSuccess(
    quote: QuoteUiState,
    painter: Painter,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.padding(margin),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (quote.textPosition == TextPosition.LEFT) {
            QuoteText(quote, Modifier.weight(2f))
            AuthorImage(painter, Modifier.weight(1f))
        } else {
            AuthorImage(painter, Modifier.weight(1f))
            QuoteText(quote, Modifier.weight(2f))
        }
    }
}