package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.Quote

interface QuoteRepository {
    fun getQuotes(): List<Quote>
}