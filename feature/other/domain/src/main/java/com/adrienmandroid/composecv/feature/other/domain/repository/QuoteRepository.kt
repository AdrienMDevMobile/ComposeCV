package com.adrienmandroid.composecv.feature.other.domain.repository

import com.adrienmandroid.composecv.feature.other.domain.model.Quote

interface QuoteRepository {
    fun getQuotes(): List<Quote>
}