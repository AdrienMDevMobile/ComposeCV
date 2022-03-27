package com.adrienmandroid.composecv.ui.welcome

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.data.listOfItemInBottomSheet
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

fun LazyListScope.BottomsheetBody() {
    items(items = listOfItemInBottomSheet()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Magenta)
                .padding(start = 10.dp, end = 10.dp, top = 5.dp)
        ) {
            it.Draw()
        }
    }
}

@Composable
@Preview
fun PreviewBottomsheetBody() {
    ComposeCVTheme {
        LazyColumn() {
            BottomsheetBody()
        }
    }
}