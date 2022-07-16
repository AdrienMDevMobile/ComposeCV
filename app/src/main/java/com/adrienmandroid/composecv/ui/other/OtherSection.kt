package com.adrienmandroid.composecv.ui.other

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adrienmandroid.composecv.R

fun LazyListScope.otherSection(
    composable: @Composable () -> Unit,
    @StringRes title: Int? = null,
    firstElement: Boolean = false
) {
    item {
        Column(modifier = Modifier.fillMaxWidth()) {
            val spacingTop = when (firstElement) {
                true -> 20.dp
                false -> 10.dp
            }
            Spacer(modifier = Modifier.height(spacingTop))
            if (title != null) {
                Text(
                    text = stringResource(title),
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(start = 5.dp)
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
            composable()
        }
    }
}

@Composable
@Preview
fun PreviewOtherSection() {
    LazyColumn() {
        otherSection({ Gratitudes() }, title = R.string.title_gratitude)
    }
}