package com.adrienmandroid.composecv.feature.data.remote.elements

import com.adrienmandroid.composecv.feature.data.remote.WelcomeRemoteResponseHeader
import kotlinx.serialization.Serializable

@Serializable
data class WelcomeRemoteResponse(
    val header: WelcomeRemoteResponseHeader,
    val body: List<WelcomeRemoteBodyElement>
)