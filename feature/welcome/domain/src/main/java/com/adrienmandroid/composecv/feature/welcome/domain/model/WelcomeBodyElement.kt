package com.adrienmandroid.composecv.feature.welcome.domain.model

import androidx.annotation.DrawableRes
import com.adrienmandroid.composecv.model.TypographyEnum
import java.util.Date

sealed class WelcomeBodyElement {
    class WelcomeImage(
        val source: String,
        val description: String,
        val tint: Boolean = false
    ) : WelcomeBodyElement()

    class WelcomeKeywordList(val keywords: List<Keyword>) : WelcomeBodyElement()
    class WelcomeQuote(val quote: String) : WelcomeBodyElement()
    class WelcomeText(
        @DrawableRes
        val iconId: Int? = null,
        val value: String,
        val style: TypographyEnum = TypographyEnum.BODY1,
        val clickable: Clickable? = null
    ) : WelcomeBodyElement()

    class BirthdayText(
        val value: Date,
    ) : WelcomeBodyElement()
}