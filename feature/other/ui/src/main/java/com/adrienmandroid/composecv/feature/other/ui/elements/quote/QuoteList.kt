package com.adrienmandroid.composecv.feature.other.ui.elements.quote

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.adrienmandroid.composecv.core.ui.carousel.CarouselAccessibilityArrows
import com.adrienmandroid.composecv.core.ui.rememberIsAccessibilityEnabled
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.ui.preview.data.QuotePreviewParameterData
import com.adrienmandroid.composecv.feature.other.ui.state.QuoteUiState

@Composable
fun QuoteList(
    quotes: List<QuoteUiState>
) {
    val accessOn = rememberIsAccessibilityEnabled()
    QuoteList(quotes, accessOn, 0)
}

@Composable
fun QuoteList(
    quotes: List<QuoteUiState>,
    accessOn: Boolean,
    initialPage: Int = 0,
) {
    val pagerState = rememberPagerState(initialPage = initialPage) {
        quotes.size
    }

    Box {
        QuoteCarousel(quotes, pagerState)

        if (accessOn) {
            CarouselAccessibilityArrows(pagerState)
        }
    }
}

@Composable
@PreviewLightDark
fun PreviewQuoteListNoAccessibility() {
    val quotes = QuotePreviewParameterData.quotes
    ComposeCVTheme {
        QuoteList(quotes.quotes, false)
    }
}

@Composable
@PreviewLightDark
fun PreviewStudyListMiddleElementAccessibility() {
    val quotes = QuotePreviewParameterData.quotes
    ComposeCVTheme {
        QuoteList(quotes = quotes.quotes, accessOn = true, initialPage = 1)
    }
}