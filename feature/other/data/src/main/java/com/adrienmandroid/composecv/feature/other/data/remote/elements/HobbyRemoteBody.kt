package com.adrienmandroid.composecv.feature.other.data.remote.elements

import kotlinx.serialization.Serializable

@Serializable
data class HobbyRemoteBody(
    val name: String,
    val pictureUrl: String,
    val category: String
)