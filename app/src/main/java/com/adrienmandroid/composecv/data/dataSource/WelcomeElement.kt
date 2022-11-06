package com.adrienmandroid.composecv.data.dataSource

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.text.TextStyle
import com.adrienmandroid.composecv.data.Clickable
import com.adrienmandroid.composecv.data.Keyword

sealed class WelcomeElement {
    class WelcomeImage(val source: Int, val description: String) : WelcomeElement()
    class WelcomeKeyword(val keywords: Array<Keyword>) : WelcomeElement()
    class WelcomeQuote(val id: Int) : WelcomeElement()
    class WelcomeText(
        @DrawableRes
        val iconId: Int? = null,
        @StringRes
        val id: Int,
        val style: TextStyle = TextStyle(),
        val args: Array<Any> = emptyArray(),
        val clickable: Clickable? = null
    ) : WelcomeElement()
}