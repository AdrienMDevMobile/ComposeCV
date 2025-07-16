package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import com.adrienmandroid.composecv.core.ui.getDifferenceYearsToString
import com.adrienmandroid.composecv.core.ui.toMaterialTypography
import com.adrienmandroid.composecv.feature.welcome.domain.model.Clickable
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CheckUiType(value: WelcomeBodyElement, onClick: (Clickable) -> Unit) {
    when (value) {
        is WelcomeBodyElement.WelcomeImage -> ImageDraw(
            source = value.source,
            description = value.description,
            tint = value.tint,
        )

        is WelcomeBodyElement.WelcomeKeyword -> Keywords(keywords = value.keywords)
        is WelcomeBodyElement.WelcomeQuote -> QuoteTextDraw(quote = value.quote)
        is WelcomeBodyElement.WelcomeText ->
            TextDraw(
                iconId = value.iconId,
                value = value.value,
                style = value.style.toMaterialTypography(),
                onClick = value.clickable?.let { clickable: Clickable ->
                    { onClick(clickable) }
                }
            )
        is WelcomeBodyElement.BirthdayText ->
            TextDraw(
                iconId = value.iconId,
                value = value.value.getDifferenceYearsToString(),
                style = value.style.toMaterialTypography(),
            )
    }
}