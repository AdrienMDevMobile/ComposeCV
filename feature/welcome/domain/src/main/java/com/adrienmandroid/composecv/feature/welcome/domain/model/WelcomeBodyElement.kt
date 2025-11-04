package com.adrienmandroid.composecv.feature.welcome.domain.model

import androidx.annotation.DrawableRes
import com.adrienmandroid.composecv.model.TypographyEnum
import java.util.Date

sealed class WelcomeBodyElement {
    //TODO : Image source from String : web url
    class WelcomeImage(val source: Int, val description: String,
                       //TODO add tint in remotebody
        val tint: Boolean = false) :
        WelcomeBodyElement()

    //TODO : no present on data layer
    class WelcomeKeywordList(val keywords: List<Keyword>) : WelcomeBodyElement()
    class WelcomeQuote(val quote: String) : WelcomeBodyElement()
    class WelcomeText(
        @DrawableRes
        val iconId: Int? = null,
        val value: String,
        //TODO add to data layer
        val style: TypographyEnum = TypographyEnum.BODY1,
        //TODO add to data layer
        val clickable: Clickable? = null
    ) : WelcomeBodyElement()
    //TODO add to data layer
    class BirthdayText(
        val value: Date,
    ): WelcomeBodyElement()
}