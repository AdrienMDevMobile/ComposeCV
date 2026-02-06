package com.adrienmandroid.composecv.feature.welcome.ui.preview

import com.adrienmandroid.composecv.feature.welcome.domain.model.Keyword
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeIcon
import com.adrienmandroid.composecv.model.TypographyEnum

class WelcomePreviewParameterData {
    internal val welcomeBodyElements = listOf(
        WelcomeBodyElement.WelcomeText(
            icon = WelcomeIcon.LOCATION,
            value = "Value element 1 Text",
            style = TypographyEnum.H5
        ),
        WelcomeBodyElement.WelcomeQuote("Value element 2 Quote"),
        WelcomeBodyElement.WelcomeImage(
            "",
            "Text element 2 Quote",
            tint = true
        ),
        WelcomeBodyElement.WelcomeKeywordList(
            listOf(
                Keyword("Keyword1"),
                Keyword("Keyword2"),
                Keyword("Keyword3"),
            )
        )
    )
}