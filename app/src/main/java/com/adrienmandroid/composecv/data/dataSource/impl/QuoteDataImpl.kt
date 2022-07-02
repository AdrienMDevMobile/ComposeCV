package com.adrienmandroid.composecv.data.dataSource.impl

import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.Quote
import com.adrienmandroid.composecv.data.dataSource.QuoteData

class QuoteDataImpl : QuoteData {
    override fun getQuotes() = listOf(
        Quote(R.string.quoteMeditation, "Mark Twain", R.drawable.quote_mark_twain),
        Quote(R.string.quoteGirls, "Gabriel Garcia Marquez", R.drawable.quote_gabriel_garcia),
        Quote(R.string.quoteAdapt, "Stephen Hawking", R.drawable.quote_stephen_hawing)
    )
}