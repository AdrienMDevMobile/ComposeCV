package com.adrienmandroid.composecv.ui.other

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

fun LazyListScope.signature() {
    item {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Canvas(
                modifier = Modifier.size(102.dp, 127.dp)
                //modifier = Modifier.fillMaxWidth().wrapContentSize(align = Alignment.Center)
            ) {
                drawOval(topLeft = Offset(((size.width/2)-140), 0f), size = Size(280f, 350f), color = Color.Black)
                drawOval(topLeft = Offset(((size.width/2)-112), 14f), size = Size(224f, 238f), color = Color.White)
                drawOval(topLeft = Offset(((size.width/2)-70), 5f), size = Size(140f, 70f), color = Color.Black)
            }
        }

    }
}

@Preview
@Composable
fun PreviewSignature() {
    ComposeCVTheme {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth().height(500.dp)
                .background(MaterialTheme.colors.background)
        ) {
            signature()
        }


    }
}