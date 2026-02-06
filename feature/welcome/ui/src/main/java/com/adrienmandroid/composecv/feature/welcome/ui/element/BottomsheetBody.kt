package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.welcome.domain.model.Clickable
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.ui.preview.WelcomePreviewParameterData

fun LazyListScope.bottomsheetBody(
    welcomeBodyElements: List<WelcomeBodyElement>,
    onClick: (Clickable) -> Unit,
) {
    items(items = welcomeBodyElements) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.background)
                .padding(start = 10.dp, end = 10.dp, top = 5.dp)
        ) {
            CheckUiType(it, onClick)
        }
    }
}

@PreviewLightDark
@Composable
fun PreviewBottomsheetBody() {
    ComposeCVTheme {
        LazyColumn {
            bottomsheetBody(
                WelcomePreviewParameterData().welcomeBodyElements
            ) {}
        }
    }
}