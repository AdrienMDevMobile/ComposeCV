package com.adrienmandroid.composecv.ui.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.ui.theme.Typography
import com.adrienmandroid.composecv.ui.theme.border
import com.google.accompanist.flowlayout.FlowRow

@Composable
private fun Keyword(keyword: String) {
    val shape = CircleShape
    Text(
        text = "#$keyword",
        style = Typography.body1.copy(
            color = MaterialTheme.colors.onSurface,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier
            .padding(5.dp)
            .border(2.dp, MaterialTheme.colors.border, shape)
            .background(MaterialTheme.colors.surface, shape)
            .padding(12.dp, 5.dp)
    )
}

@ExperimentalFoundationApi
@Composable
fun Keywords(vararg keywords: String) {
    FlowRow {
        for (keyword in keywords) {
            Keyword(keyword = keyword)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun PreviewKeywords() {
    ComposeCVTheme() {
        Keywords("motCle0---------0", "motCle1---------0", "motCle2---------0", "motCle3----0")
    }
}