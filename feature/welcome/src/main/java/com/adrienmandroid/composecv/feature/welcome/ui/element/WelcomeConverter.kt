package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.adrienmandroid.composecv.core.ui.toMaterialTypography
import com.adrienmandroid.composecv.model.WelcomeElement

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CheckUiType(value: WelcomeElement, clickViewModel: ClickViewModel) {
    when (value) {
        is WelcomeElement.WelcomeImage -> ImageDraw(
            source = value.source,
            description = value.description,
            tint = value.tint,
        )
        is WelcomeElement.WelcomeKeyword -> Keywords(keywords = value.keywords)
        is WelcomeElement.WelcomeQuote -> QuoteTextDraw(id = value.id)
        is WelcomeElement.WelcomeText -> TextDraw(
            iconId = value.iconId,
            id = value.id,
            style = value.style.toMaterialTypography(),
            args = value.args,
            clickable = value.clickable.toViewClick(),
            clickViewModel = clickViewModel
        )
    }
}