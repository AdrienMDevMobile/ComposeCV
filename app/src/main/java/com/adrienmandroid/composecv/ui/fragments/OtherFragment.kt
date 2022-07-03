package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.Quote
import com.adrienmandroid.composecv.data.dataSource.impl.QuoteDataImpl
import com.adrienmandroid.composecv.ui.other.CardDraw
import com.adrienmandroid.composecv.ui.other.QuoteCarousel
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

@Composable
fun OtherFragment() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center,
    )
    {
        QuoteCarousel(QuoteDataImpl())
    }

}

@Composable
@Preview
fun PreviewOther() {
    ComposeCVTheme() {
        OtherFragment()
    }
}