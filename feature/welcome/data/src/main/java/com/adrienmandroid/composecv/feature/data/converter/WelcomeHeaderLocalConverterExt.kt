package com.adrienmandroid.composecv.feature.data.converter

import com.adrienmandroid.composecv.feature.data.local.WelcomeHeaderEntity
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeHeader

fun WelcomeHeader.toLocalEntity() = WelcomeHeaderEntity(
    profilePicture = profilePictureUrl,
    backgroundPicture = backgroundPictureUrl
)

fun WelcomeHeaderEntity.toDomain() = WelcomeHeader(
    profilePictureUrl = profilePicture,
    backgroundPictureUrl = backgroundPicture
)