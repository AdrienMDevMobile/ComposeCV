package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.adrienmandroid.composecv.model.welcome.WelcomeElement

/*
@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun setWelcomeView(data: ArrayList<WelcomeElement>, clickViewModel: ClickViewModel) {
    data.forEach { value ->
        checkUiType(value, clickViewModel)
    }
} */

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
            //TODO
            style = TextStyle(),
            args = value.args,
            clickable = value.clickable.toViewClick(),
            clickViewModel = clickViewModel
        )
    }
}