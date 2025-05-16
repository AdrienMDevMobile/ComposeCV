package com.adrienmandroid.composecv.data

import com.adrienmandroid.composecv.data.model.Quote

interface QuoteData {
    fun getQuotes(): List<Quote>
}