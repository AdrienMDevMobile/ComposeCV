package com.adrienmandroid.composecv.feature.other.preview.data

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.model.Quote

class QuotePreviewParameterProvider : PreviewParameterProvider<List<Quote>> {
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