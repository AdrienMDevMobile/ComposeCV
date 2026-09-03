package com.adrienmandroid.composecv.feature.other.ui.elements.quote

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.carousel.CarouselPagerIndicator
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.ui.preview.data.QuotePreviewParameterData
import com.adrienmandroid.composecv.feature.other.ui.state.QuoteUiState

@Composable
fun QuoteCarousel(
    quotes: List<QuoteUiState>,
    pagerState: PagerState,
    ) {
    Column {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 12.dp),
        ) { page ->
            QuoteCardDraw(quotes[page])
        }
        CarouselPagerIndicator(pagerState)

    }
}

@PreviewLightDark
@Composable
fun PreviewQuoteCarousel() {
    ComposeCVTheme {
        val quotes = QuotePreviewParameterData.quotes.quotes
        QuoteCarousel(
            quotes,
            PagerState { quotes.size }
        )
    }
}