package com.adrienmandroid.composecv.feature.other.ui.elements.quote

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.allowHardware
import coil3.request.crossfade
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.theme.quoteBackground
import com.adrienmandroid.composecv.feature.other.ui.preview.data.QuoteIndexedPreviewParameterProvider
import com.adrienmandroid.composecv.feature.other.ui.state.QuoteUiState

internal val margin = 12.dp

@Composable
fun QuoteCardDraw(
    quote: QuoteUiState,
    quoteContent: @Composable (QuoteUiState) -> Unit = { QuoteContent(quote) },
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
        quoteContent(quote)
    }
}

@Composable
fun QuoteContent(
    quote: QuoteUiState,
    testShowOnError: @Composable () -> Unit = {},
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
        loading = {
            QuoteLoading()
        },
        success = { successState ->
            QuoteSuccess(
                quote = quote,
                painter = successState.painter,
            )
        },
        error = {
            if (LocalInspectionMode.current) {
                testShowOnError()
            } else {
                QuoteError(quote)
            }
        },
    )
}

/**
Note : if the text is too long, AdaptableTextSize won't show initially.
since Preview only refreshes once, it won't try to show a second time.
In the app it will refresh until it fits
 */
@PreviewLightDark
@Composable
fun PreviewQuoteCardSuccess(
    @PreviewParameter(
        QuoteIndexedPreviewParameterProvider::class,
        limit = 2
    )
    quote: QuoteUiState
) {
    val painterDrawable = painterResource(R.drawable.img_test)
    ComposeCVTheme {
        QuoteCardDraw(
            quote = quote,
            quoteContent = {
                QuoteContent(
                    quote,
                    testShowOnError = { QuoteSuccess(quote, painterDrawable) }
                )
            }
        )
    }
}

@PreviewLightDark
@Composable
fun PreviewQuoteCardError(
    @PreviewParameter(
        QuoteIndexedPreviewParameterProvider::class,
        limit = 2
    )
    quote: QuoteUiState
) {
    ComposeCVTheme {
        QuoteCardDraw(
            quote = quote,
            quoteContent = {
                QuoteContent(
                    quote,
                    testShowOnError = { QuoteError(quote) }
                )
            }
        )
    }
}

@PreviewLightDark
@Composable
fun PreviewQuoteCardLoading(
    @PreviewParameter(
        QuoteIndexedPreviewParameterProvider::class,
        limit = 1
    )
    quote: QuoteUiState
) {
    ComposeCVTheme {
        QuoteCardDraw(
            quote = quote,
            quoteContent = {
                QuoteContent(
                    quote,
                    testShowOnError = { QuoteLoading() }
                )
            }
        )
    }
}