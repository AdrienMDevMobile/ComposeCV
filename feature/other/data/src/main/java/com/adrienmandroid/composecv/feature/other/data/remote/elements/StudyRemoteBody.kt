package com.adrienmandroid.composecv.feature.other.data.remote.elements

import kotlinx.serialization.Serializable

@Serializable
data class StudyRemoteBody(
    val logoUrl: String,
    val name: String,
    val diploma: String,
    val dates: Dates,
    val isLongString: Boolean = false
)

@Serializable
data class Dates(val begin: Long, val end: Long?)