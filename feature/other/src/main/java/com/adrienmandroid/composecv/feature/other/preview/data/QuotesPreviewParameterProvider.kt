package com.adrienmandroid.composecv.feature.other.preview.data

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.model.Quote

class QuoteIndexedPreviewParameterProvider : PreviewParameterProvider<Pair<Int, Quote>> {
    override val values: Sequence<Pair<Int, Quote>>
        get() = QuotePreviewParameterData.quotes.asSequence()
            .mapIndexed { index, quote -> index to quote }
}

class QuotesPreviewParameterProvider : PreviewParameterProvider<List<Quote>> {
    override val values: Sequence<List<Quote>>
        get() = sequenceOf(QuotePreviewParameterData.quotes)
}

object QuotePreviewParameterData {
    internal val quotes = listOf(
        Quote(
            R.string.test_short_text_1_line,
            R.string.test_1_word,
            R.drawable.img_test,
        ),
        Quote(
            R.string.test_short_text_1_line,
            R.string.test_1_word,
            R.drawable.img_test,
        ),
        Quote(
            R.string.test_short_text_1_line,
            R.string.test_1_word,
            R.drawable.img_test,
        )
    )
}