package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.adrienmandroid.composecv.core.ui.toMaterialTypography
import com.adrienmandroid.composecv.feature.welcome.viewmodel.WelcomeViewModel
import com.adrienmandroid.composecv.model.WelcomeBodyElement

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CheckUiType(value: WelcomeBodyElement, onClick: (WelcomeViewModel.ClickAction) -> Unit) {
    when (value) {
        is WelcomeBodyElement.WelcomeImage -> ImageDraw(
            source = value.source,
            description = value.description,
            tint = value.tint,
        )
        is WelcomeBodyElement.WelcomeKeyword -> Keywords(keywords = value.keywords)
        is WelcomeBodyElement.WelcomeQuote -> QuoteTextDraw(id = value.id)
        is WelcomeBodyElement.WelcomeText -> TextDraw(
            iconId = value.iconId,
            value = value.value,
            style = value.style.toMaterialTypography(),
            clickAction = value.clickable.toViewClick(),
            onClick = onClick
        )
    }
}