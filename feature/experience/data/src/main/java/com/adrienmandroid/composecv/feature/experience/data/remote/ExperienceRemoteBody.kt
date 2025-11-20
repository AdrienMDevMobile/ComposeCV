package com.adrienmandroid.composecv.feature.experience.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class ExperienceRemoteBody(
    val name: String,
    val employer: String? = null,
    val logoUrl: String,
    val expDates: Dates,
    val professional: Boolean,
    val informations: List<ExperienceInformationRemoteBody>
)

@Serializable
data class Dates(val begin: Long, val end: Long?)

@Serializable
data class ExperienceInformationRemoteBody(val name: String)