package com.adrienmandroid.composecv.ui.other

import androidx.compose.runtime.Composable
import com.adrienmandroid.composecv.data.dataSource.QuoteData
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@OptIn(ExperimentalPagerApi::class)
@Composable
fun QuoteCarousel(data : QuoteData) {
    val quotes = data.getQuotes()

    HorizontalPager(count = quotes.size) { page ->
        CardDraw(quotes[page], page)
    }
}