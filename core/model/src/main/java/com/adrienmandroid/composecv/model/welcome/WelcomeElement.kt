package com.adrienmandroid.composecv.model.welcome

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.adrienmandroid.composecv.model.Clickable
import com.adrienmandroid.composecv.model.TypographyEnum

sealed class WelcomeElement {
    class WelcomeImage(val source: Int, val description: String, val tint: Boolean = false) :
        WelcomeElement()
    class WelcomeKeyword(val keywords: Array<com.adrienmandroid.composecv.model.Keyword>) : WelcomeElement()
    class WelcomeQuote(val id: Int) : WelcomeElement()
    class WelcomeText(
        @DrawableRes
        val iconId: Int? = null,
        @StringRes
        val id: Int,
        val style: TypographyEnum = TypographyEnum.BODY1,
        val args: Array<Any> = emptyArray(),
        val clickable: Clickable? = null
    ) : WelcomeElement()
}