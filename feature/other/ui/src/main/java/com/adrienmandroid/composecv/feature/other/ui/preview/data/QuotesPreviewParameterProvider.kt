package com.adrienmandroid.composecv.feature.other.ui.preview.data

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adrienmandroid.composecv.feature.other.domain.model.Quote
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState
import com.adrienmandroid.composecv.feature.other.ui.state.QuoteUiState
import com.adrienmandroid.composecv.feature.other.ui.state.TextPosition

class QuoteIndexedPreviewParameterProvider :
    PreviewParameterProvider<QuoteUiState> {
    override val values: Sequence<QuoteUiState>
        get() = QuotePreviewParameterData.quotes.quotes.asSequence()
}

object QuotePreviewParameterData {
    internal val quotes = OtherComponentUiState.QuoteUiStates(
        listOf(
            QuoteUiState(
                "Lorem ipsum dolor sit amet.",
                "Lorem ipsum",
                "",
                TextPosition.LEFT,
            ),
            QuoteUiState(
                "Lorem ipsum dolor sit amet.",
                "Lorem ipsum",
                "",
                TextPosition.RIGHT,

                ),
        )
    )
}