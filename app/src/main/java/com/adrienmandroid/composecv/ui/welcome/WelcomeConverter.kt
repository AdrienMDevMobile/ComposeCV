package com.adrienmandroid.composecv.ui.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.adrienmandroid.composecv.data.dataSource.WelcomeElement
import com.adrienmandroid.composecv.ui.nav.intents.ClickViewModel
import com.adrienmandroid.composecv.ui.nav.intents.toViewClick

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
            style = value.style,
            args = value.args,
            clickable = value.clickable.toViewClick(),
            clickViewModel = clickViewModel
        )
    }
}