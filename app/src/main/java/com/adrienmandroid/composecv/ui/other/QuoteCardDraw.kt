package com.adrienmandroid.composecv.ui.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.adrienmandroid.composecv.ui.theme.onQuoteBackground
import com.adrienmandroid.composecv.ui.theme.quoteBackground

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CardDraw(quote: Quote, position: Int) {
    val marginTop = 12.dp
    val marginBottom = 12.dp
    val marginStart = 12.dp
    val marginEnd = 12.dp
    val marginBetween = 16.dp

    val textLeft = (position % 2 == 0)

    val textStyle = TextStyle(
        color = MaterialTheme.colors.onQuoteBackground
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
            val (text, image, author) = createRefs()

            Text(
                text = stringResource(quote.text),
                style = textStyle.copy(fontSize = 14.sp),
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
                text = quote.author,
                style = textStyle.copy(fontSize = 10.sp),
                modifier = Modifier.constrainAs(author) {
                    top.linkTo(text.bottom)
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    start.linkTo(text.start)
                }
            )
            Image(
                painter = painterResource(id = quote.image),
                contentDescription = quote.author,
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
fun previewQuoteCard() {
    CardDraw(
        quote = Quote(R.string.quoteMeditation, "Mark Twain", R.drawable.quote_mark_twain),
        position = 1
    )
}