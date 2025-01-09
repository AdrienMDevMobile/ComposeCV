package com.adrienmandroid.composecv.data.dataSource.impl

import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.Quote
import com.adrienmandroid.composecv.data.dataSource.QuoteData

class QuoteDataImpl : QuoteData {
    override fun getQuotes() = listOf(
        Quote(R.string.quoteMeditation, R.string.quoteAuthorMarkTwain, R.drawable.quote_mark_twain),
        Quote(R.string.quoteGirls, R.string.quoteAuthorGabrielGarciaMarquez, R.drawable.quote_gabriel_garcia),
        Quote(R.string.quoteAdapt, R.string.quoteAuthorStephenHawking, R.drawable.quote_stephen_hawing)
    )
}