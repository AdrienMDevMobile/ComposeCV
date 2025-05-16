package com.adrienmandroid.composecv.data.model

import androidx.annotation.StringRes

data class Experience(
    @StringRes val name: Int,
    @StringRes val employer: Int? = null,
    val logo: Int,
    val expDates: Dates,
    val professional: Boolean,
    val link: Link? = null,
    val informations: List<ExperienceInformation>
)

data class ExperienceInformation(@StringRes val name: Int)