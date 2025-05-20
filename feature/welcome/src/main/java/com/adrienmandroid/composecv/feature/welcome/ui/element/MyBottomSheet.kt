package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyBottomSheet(
    contentCovered: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    anchoredContent: (@Composable () -> Unit)? = null,
    content: LazyListScope.() -> Unit,
) {
    Box(modifier = modifier) {
        contentCovered()
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }
            bottomsheetHeader(
                content = anchoredContent
            )
            content()
        }
    }
}

