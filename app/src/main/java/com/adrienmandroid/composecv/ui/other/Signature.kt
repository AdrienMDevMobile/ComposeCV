package com.adrienmandroid.composecv.ui.other

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

fun LazyListScope.signature() {
    item {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Canvas(
                modifier = Modifier.wrapContentSize()
            ) {
                drawOval(topLeft = Offset(0f, 0f), size = Size(280f, 350f), color = Color.Black)
                drawOval(topLeft = Offset(20f, 14f), size = Size(224f, 238f), color = Color.White)
                drawOval(topLeft = Offset(60f, 0f), size = Size(140f, 70f), color = Color.Black)
            }
        }

    }
}

@Preview
@Composable
fun PreviewSignature() {
    ComposeCVTheme {
        Box(modifier = Modifier.background(Color.White)) {
            LazyColumn() {
                signature()
            }
        }

    }
}