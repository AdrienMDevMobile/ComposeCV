package com.adrienmandroid.composecv.ui.welcome

import android.text.Html
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.ui.nav.intents.ClickViewModel
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.ui.theme.border

class QuoteTextDraw(private val id: Int, private val args: Array<Any> = emptyArray()) : SimpleDraw {
    @Composable
    override fun Draw(clickViewModel: ClickViewModel) {
        val shape = RectangleShape
        Text(
            text = stringResource(id, *args),
            style = TextStyle(
                color = MaterialTheme.colors.onSurface,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, MaterialTheme.colors.border, shape)
                .background(MaterialTheme.colors.surface, shape)
                .padding(16.dp)
        )
    }
}

@Composable
@Preview
fun PreviewQuoteTextDraw(){
    val quoteTextDraw = QuoteTextDraw(R.string.selfPresentation)
    ComposeCVTheme {
        Box(modifier = Modifier.background(Color.Blue)) {
            Row(){
                Spacer(modifier = Modifier.width(20.dp))
                quoteTextDraw.Draw(ClickViewModel())
            }
        }
    }
}