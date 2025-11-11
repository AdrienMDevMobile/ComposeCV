package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adrienmandroid.composecv.core.ui.AutoResizeText
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.theme.onQuoteBackground
import com.adrienmandroid.composecv.core.ui.theme.quoteBackground
import com.adrienmandroid.composecv.feature.other.ui.R
import com.adrienmandroid.composecv.feature.other.ui.preview.data.QuoteIndexedPreviewParameterProvider
import com.adrienmandroid.composecv.feature.other.ui.state.QuoteUiState

private val margin = 12.dp

@Composable
fun QuoteCardDraw(
    quote: QuoteUiState,
    //TODO have this code only compiled in test build ?
    testStayLoading: Boolean = false,
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
        QuoteLoadingContent(quote, testStayLoading)
    }
}

@Composable
fun QuoteLoadingContent(
    quote: QuoteUiState,
    testStayLoading: Boolean = false,
) {
    var isLoading by remember { mutableStateOf(true) }
    var isError by remember { mutableStateOf(false) }
    /*TODO
    val imageLoader = rememberAsyncImagePainter(
        model = quote.imageUrl,
        onState = { state ->
            isLoading = state is AsyncImagePainter.State.Loading
            isError = state is AsyncImagePainter.State.Error
        },
    )

    val isLocalInspection = LocalInspectionMode.current

    QuoteContent(
        quote,
        showLoading = isLoading && !isLocalInspection || testStayLoading,
        showError = isError && !isLocalInspection,
        imageLoader
    )*/
}

/*
@Composable
fun QuoteContent(
    quote: QuoteUiState,
    showLoading: Boolean,
    showError: Boolean,
    imageLoader: AsyncImagePainter
) {
    if (showLoading) {
        Box(
            modifier = Modifier.padding(margin),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.secondary,
            )
            //Used to preload the picture, hidden in the loader
            Image(
                painter = imageLoader,
                modifier = Modifier.alpha(0F),
                contentDescription = "@null"
            )
        }

    } else {
        Row(
            modifier = Modifier.padding(margin),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (quote.textPosition == TextPosition.LEFT) {
                QuoteText(quote, Modifier.weight(2f))
                AuthorImage(imageLoader, showError, Modifier.weight(1f))
            } else {
                AuthorImage(imageLoader, showError, Modifier.weight(1f))
                QuoteText(quote, Modifier.weight(2f))
            }
        }
    }
}

@Composable
fun AuthorImage(
    imageLoader: AsyncImagePainter,
    showError: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight(),
            contentScale = ContentScale.Crop,
            painter = if (!showError) {
                imageLoader
            } else {
                painterResource(RCoreUi.drawable.core_placeholder)
            },
            contentDescription = "@null",
        )
    }
}
*/
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

@PreviewLightDark
@Composable
fun PreviewQuoteCardText(
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
}