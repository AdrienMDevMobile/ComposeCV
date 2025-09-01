package com.adrienmandroid.composecv.feature.experience.domain.model

import com.adrienmandroid.composecv.model.Dates

data class Experience(
    val name: String,
    val employer: String? = null,
    val logoUrl: String,
    val expDates: Dates,
    val professional: Boolean,
    //val link: Link? = null,
    val informations: List<ExperienceInformation>
)

data class ExperienceInformation(val name: String)