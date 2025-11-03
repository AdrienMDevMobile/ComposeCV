package com.adrienmandroid.composecv.feature.data.converter

import com.adrienmandroid.composecv.feature.data.remote.WelcomeRemoteBodyElement
import com.adrienmandroid.composecv.feature.data.remote.WelcomeRemoteResponseHeader
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader

fun WelcomeRemoteBodyElement.toDomain(): WelcomeBodyElement? = when (type) {
    "IMAGE" -> if (iconId != null && value != null) WelcomeBodyElement.WelcomeImage(
        source = iconId,
        description = value
    ) else null

    else -> null
}

fun WelcomeRemoteResponseHeader.toDomain() = WelcomeHeader(
    profilePictureUrl = profilePictureUrl,
    backgroundPictureUrl = backgroundPictureUrl,
)