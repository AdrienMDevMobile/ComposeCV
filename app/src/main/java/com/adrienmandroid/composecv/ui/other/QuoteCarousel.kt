package com.adrienmandroid.composecv.ui.other

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.data.dataSource.QuoteData
import com.adrienmandroid.composecv.shared.ui.theme.carouselButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun QuoteCarousel(data: QuoteData) {
    Column() {
        val pagerState = rememberPagerState()

        val quotes = data.getQuotes()

        HorizontalPager(
            count = quotes.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 12.dp),
        ) { page ->
            CardDraw(quotes[page], page)
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = MaterialTheme.colors.carouselButton
        )
    }
}