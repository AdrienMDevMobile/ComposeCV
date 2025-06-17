package com.adrienmandroid.composecv.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class WelcomeBodyElement {
    class WelcomeImage(val source: Int, val description: String, val tint: Boolean = false) :
        WelcomeBodyElement()
    class WelcomeKeyword(val keywords: Array<Keyword>) : WelcomeBodyElement()
    class WelcomeQuote(val id: Int) : WelcomeBodyElement()
    class WelcomeText(
        @DrawableRes
        val iconId: Int? = null,
        @StringRes
        val id: Int,
        val style: TypographyEnum = TypographyEnum.BODY1,
        val args: Array<Any> = emptyArray(),
        val clickable: Clickable? = null
    ) : WelcomeBodyElement()
}