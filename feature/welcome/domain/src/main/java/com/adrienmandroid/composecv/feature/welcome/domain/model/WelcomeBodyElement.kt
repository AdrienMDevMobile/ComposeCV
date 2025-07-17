package com.adrienmandroid.composecv.feature.welcome.domain.model

import androidx.annotation.DrawableRes
import com.adrienmandroid.composecv.model.TypographyEnum
import java.util.Date

sealed class WelcomeBodyElement {
    //TODO : Image source from String : web url
    class WelcomeImage(val source: Int, val description: String, val tint: Boolean = false) :
        WelcomeBodyElement()

    class WelcomeKeyword(val keywords: Array<Keyword>) : WelcomeBodyElement()
    class WelcomeQuote(val quote: String) : WelcomeBodyElement()
    class WelcomeText(
        @DrawableRes
        val iconId: Int? = null,
        val value: String,
        val style: TypographyEnum = TypographyEnum.BODY1,
        val clickable: Clickable? = null
    ) : WelcomeBodyElement()
    class BirthdayText(
        @DrawableRes
        val iconId: Int? = null,
        val value: Date,
        val style: TypographyEnum = TypographyEnum.BODY1,
    ): WelcomeBodyElement()
}