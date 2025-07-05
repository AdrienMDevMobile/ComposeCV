package com.adrienmandroid.composecv.model

import androidx.annotation.DrawableRes

data class Experience(
    val name: String,
    val employer: String? = null,
    //TODO later : renvoyer l'url de l'icone
    @DrawableRes val logo: Int,
    val expDates: Dates,
    val professional: Boolean,
    val link: Link? = null,
    val informations: List<ExperienceInformation>
)

data class ExperienceInformation(val name: String)