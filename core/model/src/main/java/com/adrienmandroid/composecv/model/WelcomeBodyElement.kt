package com.adrienmandroid.composecv.model

import androidx.annotation.DrawableRes

sealed class WelcomeBodyElement {
    class WelcomeImage(val source: Int, val description: String, val tint: Boolean = false) :
        WelcomeBodyElement()

    class WelcomeKeyword(val keywords: Array<Keyword>) : WelcomeBodyElement()
    class WelcomeQuote(val id: Int) : WelcomeBodyElement()
    class WelcomeText(
        @DrawableRes
        val iconId: Int? = null,
        val value: String,
        val style: TypographyEnum = TypographyEnum.BODY1,
        val clickable: Clickable? = null
    ) : WelcomeBodyElement()
}