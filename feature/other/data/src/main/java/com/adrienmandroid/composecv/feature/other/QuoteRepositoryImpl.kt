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
            text = context.getString(R.string.quoteAdapt),
            author = context.getString(R.string.quoteAuthorStephenHawking),
            imageUrl = "https://cvportfolioadrienm.blob.core.windows.net/cvportfolio/quote/quote_stephen_hawing.png"
        ),
        Quote(
            text = context.getString(R.string.quoteMeditation),
            author = context.getString(R.string.quoteAuthorMarkTwain),
            imageUrl = "https://cvportfolioadrienm.blob.core.windows.net/cvportfolio/quote/quote_mark_twain.jpg"
        ),
        Quote(
            text = context.getString(R.string.quoteGirls),
            author = context.getString(R.string.quoteAuthorGabrielGarciaMarquez),
            imageUrl = "https://cvportfolioadrienm.blob.core.windows.net/cvportfolio/quote/quote_gabriel_garcia.jpg"
        )
    )
}