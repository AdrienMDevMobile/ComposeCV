package com.adrienmandroid.composecv.feature.other.ui.elements.quote

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adrienmandroid.composecv.core.ui.AutoResizeText
import com.adrienmandroid.composecv.core.ui.theme.onQuoteBackground
import com.adrienmandroid.composecv.feature.other.ui.R
import com.adrienmandroid.composecv.feature.other.ui.state.QuoteUiState

@Composable
fun AuthorImage(
    painter: Painter,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            modifier = Modifier
                .fillMaxHeight(),
            contentScale = ContentScale.Crop,
            contentDescription = "@null",
        )
    }
}

@Composable
fun QuoteText(
    quote: QuoteUiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        QuotationMarks()
        Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
            QuoteText(quote.text)
            QuoteAuthor(quote.author)
        }
    }
}

@Composable
fun ColumnScope.QuoteText(quote: String) {
    Column(modifier = Modifier.weight(1F), verticalArrangement = Arrangement.Center) {
        AutoResizeText(
            text = quote,
            style = TextStyle(
                color = MaterialTheme.colors.onQuoteBackground,
                fontSize = 24.sp,
                lineHeight = 28.sp,
            ),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ColumnScope.QuoteAuthor(author: String) {
    Text(
        text = author,
        style = TextStyle(
            color = MaterialTheme.colors.onQuoteBackground,
            fontSize = 12.sp
        ),
        modifier = Modifier
            .align(Alignment.End)
            .padding(top = 4.dp)
    )
}

@Composable
fun QuotationMarks() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        QuoteCommas(Modifier.align(Alignment.Start))
        QuoteCommas(Modifier.align(Alignment.End), isBottom = true)
    }
}

@Composable
fun QuoteCommas(modifier: Modifier = Modifier, isBottom: Boolean = false) {
    Icon(
        painter = painterResource(id = R.drawable.ic_quote),
        contentDescription = "quote",
        modifier = modifier
            .size(48.dp)
            .let { if (isBottom) it else it.rotate(180f) } // Rotate top quote mark
            .padding(
                if (isBottom) PaddingValues(top = 4.dp) else PaddingValues(
                    bottom = 4.dp
                )
            ), // Add padding to avoid overlap
        tint = Color.Gray
    )
}