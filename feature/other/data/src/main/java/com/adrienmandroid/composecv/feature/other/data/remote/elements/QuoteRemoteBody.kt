package com.adrienmandroid.composecv.feature.other.data.remote.elements

import kotlinx.serialization.Serializable

@Serializable
data class QuoteRemoteBody(
    val text: String,
    val author: String,
    val imageUrl: String
)