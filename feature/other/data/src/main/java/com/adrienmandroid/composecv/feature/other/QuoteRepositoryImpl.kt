package com.adrienmandroid.composecv.feature.other

import android.content.Context
import com.adrienmandroid.composecv.feature.other.data.R
import com.adrienmandroid.composecv.feature.other.domain.repository.QuoteRepository
import com.adrienmandroid.composecv.feature.other.domain.model.Quote
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : QuoteRepository {
    override fun getQuotes() = listOf(
        Quote(
            context.getString(R.string.quoteMeditation),
            context.getString(R.string.quoteAuthorMarkTwain),
            R.drawable.quote_mark_twain
        ),
        Quote(
            context.getString(R.string.quoteGirls),
            context.getString(R.string.quoteAuthorGabrielGarciaMarquez),
            R.drawable.quote_gabriel_garcia
        ),
        Quote(
            context.getString(R.string.quoteAdapt),
            context.getString(R.string.quoteAuthorStephenHawking),
            R.drawable.quote_stephen_hawing
        )
    )
}