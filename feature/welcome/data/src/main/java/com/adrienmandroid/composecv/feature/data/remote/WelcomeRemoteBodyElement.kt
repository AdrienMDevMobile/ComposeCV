package com.adrienmandroid.composecv.feature.data.remote

data class WelcomeRemoteBodyElement(
    val type: String,

    // Fields for WelcomeText, BirthdayText, WelcomeQuote
    val value: String? = null,
    val style: TypographyRemoteBody? = null,
    val iconId: Int? = null,

    // Field for Clickable actions
    val clickable: ClickableRemoteBody? = null,

    // Fields for WelcomeImage
    val imageResId: Int? = null,
    val imageDescription: String? = null,
    val tint: Boolean? = false,

    // Field for WelcomeKeyword
    val keywords: List<String>? = null
)

