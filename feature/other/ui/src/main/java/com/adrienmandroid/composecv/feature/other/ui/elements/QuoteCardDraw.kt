package com.adrienmandroid.composecv.feature.other.ui.elements

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.compose.Dimension
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

private val marginTop = 12.dp
private val marginBottom = 12.dp
private val marginStart = 12.dp
private val marginEnd = 12.dp

@Composable
fun QuoteCardDraw(
    quote: QuoteUiState,
    testShowTextDespiteError: Boolean = false
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(
                RoundedCornerShape(25.dp)
            )
            .padding(10.dp, 10.dp), backgroundColor = MaterialTheme.colors.quoteBackground,
        elevation = 5.dp
    ) {
        QuoteContent(quote, testShowTextDespiteError)
    }
}

@Composable
fun QuoteContent(
    quote: QuoteUiState,
    testShowTextDespiteError: Boolean = false
) {
    val isTextLeft = quote.textPosition == TextPosition.LEFT

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

    val showImage = !isLoading && !isError || testShowTextDespiteError

    ConstraintLayout {
        val (text, image, author, quoteTop, quoteBottom, loader) = createRefs()

        if (showImage) {
            Quote(
                text = quote.text,
                author = quote.author,
                isTextLeft,
                textConstraint = text,
                authorConstraint = author,
                quoteTopConstraint = quoteTop,
                quoteBottomConstraint = quoteBottom,
                imageConstraint = image,
            )
        }

        val authorConstraintModifier = if (showImage) Modifier
            .constrainAs(image) {
                if (!isTextLeft) {
                    start.linkTo(parent.start, margin = marginStart)
                    end.linkTo(text.start)
                } else {
                    start.linkTo(text.end)
                    end.linkTo(parent.end, margin = marginEnd)
                }
                top.linkTo(parent.top, margin = marginTop)
                bottom.linkTo(parent.bottom, margin = marginBottom)
                height = Dimension.fillToConstraints
            } else Modifier.constrainAs(image) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top, margin = marginTop)
            bottom.linkTo(parent.bottom, margin = marginBottom)
            height = Dimension.fillToConstraints
        }
        AuthorPicture(
            contentDescription = quote.author,
            isError = isError,
            isLocalInspection = isLocalInspection,
            imageLoader = imageLoader,
            constraintModifier = authorConstraintModifier
        )

        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.constrainAs(loader) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top, margin = 4.dp)
                    bottom.linkTo(parent.bottom, margin = 4.dp)
                },
                color = MaterialTheme.colors.secondary,
            )
        }
    }
}

@Composable
fun ConstraintLayoutScope.Quote(
    text: String,
    author: String,
    isTextLeft: Boolean,
    textConstraint: ConstrainedLayoutReference,
    authorConstraint: ConstrainedLayoutReference,
    quoteTopConstraint: ConstrainedLayoutReference,
    quoteBottomConstraint: ConstrainedLayoutReference,
    imageConstraint: ConstrainedLayoutReference,
) {
    val marginBetween = 16.dp
    val quotationMarkSize = 48.dp

    val textStyleQuote = TextStyle(
        color = MaterialTheme.colors.onQuoteBackground,
        fontSize = 16.sp
    )
    val textStyleAuthor = TextStyle(
        color = MaterialTheme.colors.onQuoteBackground,
        fontSize = 12.sp
    )

    Icon(
        painter = painterResource(id = R.drawable.ic_quote),
        contentDescription = "quote",
        modifier = Modifier
            .rotate(180F)
            .size(quotationMarkSize)
            .constrainAs(quoteTopConstraint) {
                start.linkTo(textConstraint.start, margin = (-12).dp)
                bottom.linkTo(textConstraint.top, margin = (-28).dp)
            },
        tint = Color.Gray
    )
    Icon(
        painter = painterResource(id = R.drawable.ic_quote),
        contentDescription = "quote",
        modifier = Modifier
            .size(quotationMarkSize)
            .constrainAs(quoteBottomConstraint) {
                end.linkTo(textConstraint.end, margin = (-12).dp)
                top.linkTo(textConstraint.bottom, margin = (-28).dp)
            },
        tint = Color.Gray
    )
    Text(
        text = text,
        style = textStyleQuote,
        modifier = Modifier.constrainAs(textConstraint) {
            if (isTextLeft) {
                start.linkTo(parent.start, margin = marginStart)
                end.linkTo(imageConstraint.start, margin = marginBetween)
            } else {
                start.linkTo(imageConstraint.end, margin = marginBetween)
                end.linkTo(parent.end, margin = marginEnd)
            }
            top.linkTo(parent.top, margin = marginTop)
            bottom.linkTo(authorConstraint.top)
            width = Dimension.fillToConstraints
        }
    )
    Text(
        text = author,
        style = textStyleAuthor,
        modifier = Modifier.constrainAs(authorConstraint) {
            top.linkTo(textConstraint.bottom)
            bottom.linkTo(parent.bottom, margin = 16.dp)
            end.linkTo(textConstraint.end)
        }
    )
}

@Composable
fun AuthorPicture(
    contentDescription: String,
    isError: Boolean,
    isLocalInspection: Boolean,
    imageLoader: AsyncImagePainter,
    @SuppressLint("ModifierParameter") constraintModifier: Modifier
) {
    Image(
        modifier = constraintModifier,
        contentScale = ContentScale.Crop,
        painter = if (isError.not() && !isLocalInspection) {
            imageLoader
        } else {
            painterResource(RCoreUi.drawable.core_placeholder)
        },
        contentDescription = contentDescription,
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