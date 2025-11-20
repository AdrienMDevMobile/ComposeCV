package com.adrienmandroid.composecv.feature.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class WelcomeRemoteResponseHeader(
    val profilePictureUrl: String,
    val backgroundPictureUrl: String,
)