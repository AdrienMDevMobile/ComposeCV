package com.adrienmandroid.composecv.feature.other.ui.preview.data

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adrienmandroid.composecv.feature.other.domain.model.Quote

class QuoteIndexedPreviewParameterProvider :
    PreviewParameterProvider<Pair<Int, Quote>> {
    override val values: Sequence<Pair<Int, Quote>>
        get() = QuotePreviewParameterData.quotes.asSequence()
            .mapIndexed { index, quote -> index to quote }
}

object QuotePreviewParameterData {
    internal val quotes = listOf(
        Quote(
            "Lorem ipsum dolor sit amet.",
            "Lorem ipsum",
            "",
        ),
        Quote(
            "Lorem ipsum dolor sit amet.",
            "Lorem ipsum",
            "",
        ),
    )
}