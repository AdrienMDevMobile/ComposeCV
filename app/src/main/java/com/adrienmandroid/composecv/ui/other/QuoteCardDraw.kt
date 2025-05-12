package com.adrienmandroid.composecv.ui.other

import androidx.compose.foundation.Image
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
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.Quote
import com.adrienmandroid.composecv.shared.ui.theme.onQuoteBackground
import com.adrienmandroid.composecv.shared.ui.theme.quoteBackground

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CardDraw(quote: Quote, position: Int) {
    val marginTop = 12.dp
    val marginBottom = 12.dp
    val marginStart = 12.dp
    val marginEnd = 12.dp
    val marginBetween = 16.dp
    val quotationMarkSize = 48.dp

    val textLeft = (position % 2 == 0)

    val textStyleQuote = TextStyle(
        color = MaterialTheme.colors.onQuoteBackground,
        fontSize = 16.sp
    )
    val textStyleAuthor = TextStyle(
        color = MaterialTheme.colors.onQuoteBackground,
        fontSize = 12.sp
    )
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
        ConstraintLayout {
            val (text, image, author, quoteTop, quoteBottom) = createRefs()

            Icon(
                painter = painterResource(id = R.drawable.ic_quote),
                contentDescription = "quote",
                modifier = Modifier
                    .rotate(180F)
                    .size(quotationMarkSize)
                    .constrainAs(quoteTop) {
                        start.linkTo(text.start, margin = (-12).dp)
                        bottom.linkTo(text.top, margin = (-28).dp)
                    },
                tint = Color.Gray
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_quote),
                contentDescription = "quote",
                modifier = Modifier
                    .size(quotationMarkSize)
                    .constrainAs(quoteBottom) {
                        end.linkTo(text.end, margin = (-12).dp)
                        top.linkTo(text.bottom, margin = (-28).dp)
                    },
                tint = Color.Gray
            )
            Text(
                text = stringResource(quote.text),
                style = textStyleQuote,
                modifier = Modifier.constrainAs(text) {
                    if (textLeft) {
                        start.linkTo(parent.start, margin = marginStart)
                        end.linkTo(image.start, margin = marginBetween)
                    } else {
                        start.linkTo(image.end, margin = marginBetween)
                        end.linkTo(parent.end, margin = marginEnd)
                    }
                    top.linkTo(parent.top, margin = marginTop)
                    bottom.linkTo(author.top)
                    width = Dimension.fillToConstraints
                }
            )
            Text(
                text = stringResource(quote.author),
                style = textStyleAuthor,
                modifier = Modifier.constrainAs(author) {
                    top.linkTo(text.bottom)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    end.linkTo(text.end)
                }
            )
            Image(
                painter = painterResource(id = quote.image),
                contentDescription = stringResource(quote.author),
                modifier = Modifier
                    .constrainAs(image) {
                        if (!textLeft) {
                            start.linkTo(parent.start, margin = marginStart)
                            end.linkTo(text.start)
                        } else {
                            start.linkTo(text.end)
                            end.linkTo(parent.end, margin = marginEnd)
                        }
                        top.linkTo(parent.top, margin = marginTop)
                        bottom.linkTo(parent.bottom, margin = marginBottom)
                        height = Dimension.fillToConstraints
                    }
            )
        }
    }
}

@Preview
@Composable
fun PreviewQuoteCard() {
    CardDraw(
        quote = Quote(R.string.quoteMeditation, R.string.quoteAuthorMarkTwain, R.drawable.quote_mark_twain),
        position = 1
    )
}