package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.model.Quote

interface QuoteData {
    fun getQuotes(): List<Quote>
}