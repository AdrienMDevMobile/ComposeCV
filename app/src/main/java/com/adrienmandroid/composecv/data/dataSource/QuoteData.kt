package com.adrienmandroid.composecv.data.dataSource

import com.adrienmandroid.composecv.data.Quote

interface QuoteData {
    fun getQuotes(): List<Quote>
}