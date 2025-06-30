package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.adrienmandroid.composecv.core.ui.toMaterialTypography
import com.adrienmandroid.composecv.feature.welcome.viewmodel.ClickViewModel
import com.adrienmandroid.composecv.model.WelcomeBodyElement

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CheckUiType(value: WelcomeBodyElement, clickViewModel: ClickViewModel) {
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
            id = value.id,
            style = value.style.toMaterialTypography(),
            args = value.args,
            clickable = value.clickable.toViewClick(),
            clickViewModel = clickViewModel
        )
    }
}