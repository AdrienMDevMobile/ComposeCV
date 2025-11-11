package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.allowHardware
import coil3.request.crossfade
import com.adrienmandroid.composecv.core.ui.AutoResizeText
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.theme.onQuoteBackground
import com.adrienmandroid.composecv.core.ui.theme.quoteBackground
import com.adrienmandroid.composecv.feature.other.ui.R
import com.adrienmandroid.composecv.feature.other.ui.preview.data.QuoteIndexedPreviewParameterProvider
import com.adrienmandroid.composecv.feature.other.ui.state.QuoteUiState
import com.adrienmandroid.composecv.feature.other.ui.state.TextPosition

private val margin = 12.dp

@Composable
fun QuoteCardDraw(
    quote: QuoteUiState,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(25.dp))
            .padding(10.dp),
        backgroundColor = MaterialTheme.colors.quoteBackground,
        elevation = 5.dp
    ) {
        QuoteContent(quote)
    }
}

@Composable
fun QuoteContent(
    quote: QuoteUiState,
) {
    val context = LocalPlatformContext.current

    SubcomposeAsyncImage(
        model = ImageRequest.Builder(context)
            .data(quote.imageUrl)
            .crossfade(true)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .allowHardware(false) // Better compatibility
            .build(),
        contentDescription = quote.author,
        modifier = Modifier.fillMaxSize(),
        success = { successState ->
            Row(
                modifier = Modifier.padding(margin),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (quote.textPosition == TextPosition.LEFT) {
                    QuoteText(quote, Modifier.weight(2f))
                    AuthorImage(successState.painter, Modifier.weight(1f))
                } else {
                    AuthorImage(successState.painter, Modifier.weight(1f))
                    QuoteText(quote, Modifier.weight(2f))
                }
            }
        },
        loading = {
            Box(
                modifier = Modifier.padding(margin),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.secondary,
                )
            }
        },
        error = {
            QuoteText(quote)
        }
    )
}

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

/**
Note : if the text is too long, AdaptableTextSize won't show initially.
since Preview only refreshes once, it won't try to show a second time.
In the app it will refresh until it fits
 */
@PreviewLightDark
@Composable
fun PreviewQuoteCard(
    @PreviewParameter(
        QuoteIndexedPreviewParameterProvider::class,
        limit = 2
    )
    quote: QuoteUiState
) {
    ComposeCVTheme {
        QuoteCardDraw(
            quote = quote
        )
    }
}

/*
TODO loading preview
@PreviewLightDark
@Composable
fun PreviewQuoteCardTextStayLoading(
    @PreviewParameter(
        QuoteIndexedPreviewParameterProvider::class,
        limit = 2
    )
    quote: QuoteUiState
) {
    ComposeCVTheme {
        QuoteCardDraw(
            quote = quote,
            true
        )
    }
}*/