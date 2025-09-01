package com.adrienmandroid.composecv.feature.experience.data.remote

data class Experience(
    val name: String,
    val employer: String? = null,
    val logoUrl: String,
    val expDates: Dates,
    val professional: Boolean,
    //val link: Link? = null,
    val informations: List<ExperienceInformation>
)

data class Dates(val begin: Long, val end: Long?)

data class ExperienceInformation(val name: String)