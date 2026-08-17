package com.adrienmandroid.composecv.feature.data.converter

import com.adrienmandroid.composecv.feature.data.remote.elements.ClickableRemoteBody
import com.adrienmandroid.composecv.feature.data.remote.elements.IconRemoteBody
import com.adrienmandroid.composecv.feature.data.remote.TypographyRemoteBody
import com.adrienmandroid.composecv.feature.data.remote.elements.WelcomeRemoteBodyElement
import com.adrienmandroid.composecv.feature.data.remote.WelcomeRemoteResponseHeader
import com.adrienmandroid.composecv.feature.welcome.domain.model.Clickable
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeIcon
import com.adrienmandroid.composecv.feature.welcome.domain.model.Keyword
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader
import com.adrienmandroid.composecv.model.TypographyEnum
import java.util.Date

fun WelcomeRemoteBodyElement.toDomain(): WelcomeBodyElement? = when (type) {
    "IMAGE" -> if (value != null) WelcomeBodyElement.WelcomeImage(
        source = value,
        description = imageDescription,
        tint = tint
    ) else null

    "QUOTE" -> if (value != null) WelcomeBodyElement.WelcomeQuote(
        quote = value
    ) else null

    "TEXT" -> if (value != null && style != null) WelcomeBodyElement.WelcomeText(
        icon = icon?.toDomain(),
        value = value,
        style = style.toDomain(),
        clickable = clickable?.toDomain()
    ) else null

    "KEYWORDS" -> if (keywords != null) WelcomeBodyElement.WelcomeKeywordList(
        keywords = keywords.map { word -> Keyword(value = word) }
    ) else null

    "BIRTHDAY" -> if (value != null) {
        try {
            val date = Date(value.toLong())
            WelcomeBodyElement.BirthdayText(
                value = date
            )
        } catch (_: NumberFormatException) {
            null
        }
    } else {
        null
    }

    else -> null
}

fun IconRemoteBody.toDomain() = when(this) {
    IconRemoteBody.MAIL -> WelcomeIcon.MAIL
    IconRemoteBody.LOCATION -> WelcomeIcon.LOCATION
    IconRemoteBody.GITHUB -> WelcomeIcon.GITHUB
    IconRemoteBody.LINKEDIN -> WelcomeIcon.LINKEDIN
}

fun TypographyRemoteBody.toDomain() = when (this) {
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

fun ClickableRemoteBody.toDomain() = when (type) {
    "Web" -> if (value != null) Clickable.WebClick(
        url = value
    ) else null

    "Mail" -> if (value != null) Clickable.MailClick(
        address = value
    ) else null

    else -> null
}

fun WelcomeRemoteResponseHeader.toDomain() = WelcomeHeader(
    profilePictureUrl = profilePictureUrl,
    backgroundPictureUrl = backgroundPictureUrl,
)