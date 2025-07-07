package com.adrienmandroid.composecv.feature.welcome.preview

import android.content.Context
import com.adrienmandroid.composecv.core.test.R as TestingR
import com.adrienmandroid.composecv.model.Keyword
import com.adrienmandroid.composecv.model.TypographyEnum
import com.adrienmandroid.composecv.model.WelcomeBodyElement

class WelcomePreviewParameterData(
    context: Context,
) {
    internal val welcomeBodyElements = listOf(
        WelcomeBodyElement.WelcomeText(
            value = context.getString(TestingR.string.test_short_text_1_line),
            style = TypographyEnum.H5
        ),
        WelcomeBodyElement.WelcomeQuote(context.getString(TestingR.string.test_1_word)),
        WelcomeBodyElement.WelcomeImage(
            TestingR.drawable.img_test,
            context.getString(TestingR.string.test_1_word),
            tint = true
        ),
        WelcomeBodyElement.WelcomeKeyword(
            arrayOf(

                Keyword(context.getString(TestingR.string.test_1_word)),
                Keyword(context.getString(TestingR.string.test_1_word)),
                Keyword(context.getString(TestingR.string.test_1_word)),
            )
        )
    )
}