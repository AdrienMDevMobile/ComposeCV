package com.adrienmandroid.composecv.data.impl

import com.adrienmandroid.composecv.data.R
import com.adrienmandroid.composecv.model.Quote
import com.adrienmandroid.composecv.data.QuoteRepository
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(): QuoteRepository {
    override fun getQuotes() = listOf(
        Quote(R.string.quoteMeditation, R.string.quoteAuthorMarkTwain, R.drawable.quote_mark_twain),
        Quote(R.string.quoteGirls, R.string.quoteAuthorGabrielGarciaMarquez, R.drawable.quote_gabriel_garcia),
        Quote(R.string.quoteAdapt, R.string.quoteAuthorStephenHawking, R.drawable.quote_stephen_hawing)
    )
}