package com.adrienmandroid.composecv.feature.data.remote

data class WelcomeRemoteBodyElement(
    val type: String,

    // Fields for WelcomeText, BirthdayText, WelcomeQuote, WelcomeImage
    val value: String? = null,
    val style: TypographyRemoteBody? = null,
    val icon: IconRemoteBody? = null,

    // Field for Clickable actions
    val clickable: ClickableRemoteBody? = null,

    // Fields for WelcomeImage
    val imageDescription: String? = null,
    val tint: Boolean = false,

    // Field for WelcomeKeyword
    val keywords: List<String>? = null
)

