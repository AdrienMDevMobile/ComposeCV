package com.adrienmandroid.composecv.feature.experience.data.converter

import com.adrienmandroid.composecv.feature.experience.data.remote.Experience as ExperienceRemote
import com.adrienmandroid.composecv.feature.experience.data.remote.ExperienceInformation as ExperienceInformationRemote
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation
import com.adrienmandroid.composecv.model.Dates
import java.util.Date

fun ExperienceRemote.toDomain() = Experience(
    name = name,
    employer = employer,
    logoUrl = logoUrl,
    expDates = Dates(Date(expDates.begin), expDates.end?.let { Date(it) }),
    professional = professional,
    //link = link,
    informations = informations.map { it.toDomain() }
)

fun ExperienceInformationRemote.toDomain() = ExperienceInformation(
    name = name
)