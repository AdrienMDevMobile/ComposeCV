package com.adrienmandroid.composecv.feature.data.remote.elements

import kotlinx.serialization.Serializable

@Serializable
data class ClickableRemoteBody(
    val type: String?,
    val value: String?,
)