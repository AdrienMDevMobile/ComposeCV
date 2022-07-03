package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.data.dataSource.impl.QuoteDataImpl
import com.adrienmandroid.composecv.ui.other.quoteCarousel
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

@Composable
fun OtherFragment() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
    )
    {
        quoteCarousel(QuoteDataImpl())
    }

}

@Composable
@Preview
fun PreviewOther() {
    ComposeCVTheme() {
        OtherFragment()
    }
}