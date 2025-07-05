package com.adrienmandroid.composecv.feature.welcome.preview

import android.content.Context
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.model.Keyword
import com.adrienmandroid.composecv.model.TypographyEnum
import com.adrienmandroid.composecv.model.WelcomeBodyElement

class WelcomePreviewParameterData(
    context: Context,
) {
    internal val welcomeBodyElements = listOf(
        WelcomeBodyElement.WelcomeText(
            value = context.getString(R.string.test_short_text_1_line),
            style = TypographyEnum.H5
        ),
        WelcomeBodyElement.WelcomeQuote(id = com.adrienmandroid.composecv.data.R.string.selfPresentation),
        WelcomeBodyElement.WelcomeImage(
            R.drawable.img_test,
            context.getString(R.string.test_1_word),
            tint = true
        ),
        WelcomeBodyElement.WelcomeKeyword(
            arrayOf(

                Keyword(context.getString(R.string.test_1_word)),
                Keyword(context.getString(R.string.test_1_word)),
                Keyword(context.getString(R.string.test_1_word)),
            )
        )
    )
}