package com.adrienmandroid.composecv.feature.welcome.ui.element

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.adrienmandroid.composecv.core.ui.getDifferenceInts
import com.adrienmandroid.composecv.core.ui.getDifferenceYearsToString
import com.adrienmandroid.composecv.core.ui.toMaterialTypography
import com.adrienmandroid.composecv.feature.welcome.domain.model.Clickable
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.model.Dates
import java.util.Date

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CheckUiType(value: WelcomeBodyElement, onClick: (Clickable) -> Unit) {
    when (value) {
        is WelcomeBodyElement.WelcomeImage -> ImageDraw(
            source = value.source,
            description = value.description,
            tint = value.tint,
        )

        is WelcomeBodyElement.WelcomeKeywordList -> Keywords(keywords = value.keywords.toTypedArray())
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
                iconId = null,
                value = Dates(Date(), value.value).getDifferenceInts().getDifferenceYearsToString(),
                style = MaterialTheme.typography.body1,
            )
    }
}