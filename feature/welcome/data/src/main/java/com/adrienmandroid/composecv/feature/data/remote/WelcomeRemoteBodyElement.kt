package com.adrienmandroid.composecv.feature.data.remote

import com.adrienmandroid.composecv.feature.welcome.domain.model.Keyword

data class WelcomeRemoteBodyElement(
    val type: String,

    // Fields for WelcomeText, BirthdayText, WelcomeQuote
    val value: String? = null,
    //val style: TypographyEnum? = null,
    val iconId: Int? = null,

    // Field for Clickable actions
    //val clickable: Clickable? = null,

    // Fields for WelcomeImage
    val imageResId: Int? = null,
    val imageDescription: String? = null,
    val tint: Boolean? = false,

    // Field for WelcomeKeyword
    val keywords: List<Keyword>? = null
)