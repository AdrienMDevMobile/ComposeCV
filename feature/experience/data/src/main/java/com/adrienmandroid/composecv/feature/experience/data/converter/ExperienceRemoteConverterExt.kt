package com.adrienmandroid.composecv.feature.experience.data.converter

import com.adrienmandroid.composecv.feature.experience.data.remote.ExperienceRemoteBody
import com.adrienmandroid.composecv.feature.experience.data.remote.ExperienceInformationRemoteBody
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation
import com.adrienmandroid.composecv.model.Dates
import java.util.Date

fun ExperienceRemoteBody.toDomain() = Experience(
    name = name,
    employer = employer,
    logoUrl = logoUrl,
    expDates = Dates(Date(expDates.begin), expDates.end?.let { Date(it) }),
    professional = professional,
    informations = informations.map { it.toDomain() }
)

fun ExperienceInformationRemoteBody.toDomain() = ExperienceInformation(
    name = name
)