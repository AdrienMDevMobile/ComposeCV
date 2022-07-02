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
import com.adrienmandroid.composecv.ui.other.CardDraw
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
        CardDraw(
            quote = Quote(R.string.quoteMeditation, "Mark Twain", R.drawable.quote_mark_twain),
            position = 1
        )
    }

}

@Composable
@Preview
fun PreviewOther() {
    ComposeCVTheme() {
        OtherFragment()
    }
}