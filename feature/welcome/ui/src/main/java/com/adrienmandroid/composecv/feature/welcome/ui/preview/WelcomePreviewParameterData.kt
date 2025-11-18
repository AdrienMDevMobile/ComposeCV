package com.adrienmandroid.composecv.feature.welcome.ui.preview

import android.content.Context
import com.adrienmandroid.composecv.feature.welcome.domain.model.Icon
import com.adrienmandroid.composecv.core.test.R as TestingR
import com.adrienmandroid.composecv.feature.welcome.domain.model.Keyword
import com.adrienmandroid.composecv.model.TypographyEnum
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement

class WelcomePreviewParameterData(
    context: Context,
) {
    internal val welcomeBodyElements = listOf(
        WelcomeBodyElement.WelcomeText(
            icon = Icon.LOCATION,
            value = context.getString(TestingR.string.test_short_text_1_line),
            style = TypographyEnum.H5
        ),
        WelcomeBodyElement.WelcomeQuote(context.getString(TestingR.string.test_1_word)),
        WelcomeBodyElement.WelcomeImage(
            "",
            context.getString(TestingR.string.test_1_word),
            tint = true
        ),
        WelcomeBodyElement.WelcomeKeywordList(
            listOf(

                Keyword(context.getString(TestingR.string.test_1_word)),
                Keyword(context.getString(TestingR.string.test_1_word)),
                Keyword(context.getString(TestingR.string.test_1_word)),
            )
        )
    )
}