package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.theme.onQuoteBackground
import com.adrienmandroid.composecv.core.ui.theme.quoteBackground
import com.adrienmandroid.composecv.feature.other.ui.R
import com.adrienmandroid.composecv.feature.other.ui.preview.data.QuoteIndexedPreviewParameterProvider
import com.adrienmandroid.composecv.feature.other.ui.state.QuoteUiState
import com.adrienmandroid.composecv.feature.other.ui.state.TextPosition
import com.adrienmandroid.composecv.core.ui.R as RCoreUi

private val margin = 12.dp

@Composable
fun QuoteCardDraw(
    quote: QuoteUiState,
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
    )
}

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
        }

    } else {
        Row(
            modifier = Modifier.padding(margin),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (quote.textPosition == TextPosition.LEFT) {
                QuoteText(quote, Modifier.weight(1f))
                AuthorImage(imageLoader, showError, Modifier.weight(1f))
            } else {
                AuthorImage(imageLoader, showError, Modifier.weight(1f))
                QuoteText(quote, Modifier.weight(1f))
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
        if (!showError) {
            imageLoader
        } else {
            painterResource(RCoreUi.drawable.core_placeholder)
        }
    }
}

@Composable
fun QuoteText(
    quote: QuoteUiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 8.dp),
    ) {
        QuotationMarks(Modifier.align(Alignment.Start))
        Text(
            text = quote.text,
            style = TextStyle(
                color = MaterialTheme.colors.onQuoteBackground,
                fontSize = 16.sp
            ),
            textAlign = TextAlign.Center
        )
        Text(
            text = quote.author,
            style = TextStyle(
                color = MaterialTheme.colors.onQuoteBackground,
                fontSize = 12.sp
            ),
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 4.dp)
        )
        QuotationMarks(Modifier.align(Alignment.End), isBottom = true)
    }
}

@Composable
fun QuotationMarks(modifier: Modifier = Modifier, isBottom: Boolean = false) {
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