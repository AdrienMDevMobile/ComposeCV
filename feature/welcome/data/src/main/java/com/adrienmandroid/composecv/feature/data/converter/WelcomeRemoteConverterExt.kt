package com.adrienmandroid.composecv.feature.data.converter

import com.adrienmandroid.composecv.feature.data.remote.TypographyRemoteBody
import com.adrienmandroid.composecv.feature.data.remote.WelcomeRemoteBodyElement
import com.adrienmandroid.composecv.feature.data.remote.WelcomeRemoteResponseHeader
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.model.TypographyEnum

fun WelcomeRemoteBodyElement.toDomain(): WelcomeBodyElement? = when (type) {
    /*"IMAGE" -> if (iconId != null && value != null) WelcomeBodyElement.WelcomeImage(
        source = iconId,
        description = value
    ) else null*/
    "TEXT" -> if(value != null && style != null) WelcomeBodyElement.WelcomeText(
        value = value,
        style = style.toDomain()
    ) else null

    else -> null
}

fun TypographyRemoteBody.toDomain() = when(this){
    TypographyRemoteBody.H1 -> TypographyEnum.H1
    TypographyRemoteBody.H2 -> TypographyEnum.H2
    TypographyRemoteBody.H3 -> TypographyEnum.H3
    TypographyRemoteBody.H4 -> TypographyEnum.H4
    TypographyRemoteBody.H5 -> TypographyEnum.H5
    TypographyRemoteBody.H6 -> TypographyEnum.H6
    TypographyRemoteBody.SUBTITLE1 -> TypographyEnum.SUBTITLE1
    TypographyRemoteBody.SUBTITLE2 -> TypographyEnum.SUBTITLE2
    TypographyRemoteBody.BODY1 -> TypographyEnum.BODY1
    TypographyRemoteBody.BODY2 -> TypographyEnum.BODY2
    TypographyRemoteBody.BODY1BOLD -> TypographyEnum.BODY1BOLD
    TypographyRemoteBody.BUTTON -> TypographyEnum.BUTTON
    TypographyRemoteBody.CAPTION -> TypographyEnum.CAPTION
    TypographyRemoteBody.OVERLINE -> TypographyEnum.OVERLINE
}

fun WelcomeRemoteResponseHeader.toDomain() = WelcomeHeader(
    profilePictureUrl = profilePictureUrl,
    backgroundPictureUrl = backgroundPictureUrl,
)