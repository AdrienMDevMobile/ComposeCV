package com.adrienmandroid.composecv.data

import androidx.annotation.StringRes

data class Experience(
    @StringRes val name: Int,
    @StringRes val employer: Int? = null,
    val logo: Int,
    val link: Link? = null,
    val ExpDates: Dates,
    val informations: List<ExperienceInformation>
)

data class ExperienceInformation(@StringRes val name: Int)