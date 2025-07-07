package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.theme.border
import com.adrienmandroid.composecv.core.ui.toAnnotatedString

@Composable
fun QuoteTextDraw(quote: String) {
    val shape = RectangleShape

    val text = quote.toAnnotatedString()

    Text(
        text = text,
        style = MaterialTheme.typography.body1.copy(
            color = MaterialTheme.colors.onSurface,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, MaterialTheme.colors.border, shape)
            .background(MaterialTheme.colors.surface, shape)
            .padding(16.dp)
    )
}

@Composable
@Preview
fun PreviewQuoteTextDraw() {
    ComposeCVTheme {
        Box(modifier = Modifier.background(Color.Blue)) {
            Row {
                Spacer(modifier = Modifier.width(20.dp))
                //TODO valeur string
                QuoteTextDraw("Lorem <b>ipsum</b>")
            }
        }
    }
}