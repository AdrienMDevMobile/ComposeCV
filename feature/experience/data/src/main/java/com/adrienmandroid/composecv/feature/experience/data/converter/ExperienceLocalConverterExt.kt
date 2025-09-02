package com.adrienmandroid.composecv.feature.experience.data.converter

import com.adrienmandroid.composecv.data.local.toJavaDate
import com.adrienmandroid.composecv.data.local.toRoomString
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceEntity
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceWithInformation
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation
import com.adrienmandroid.composecv.model.Dates
import com.adrienmandroid.composecv.feature.experience.data.local.ExperienceInformation as ExperienceInformationData

fun Experience.toLocalDataEntity() = ExperienceEntity(
    name = this.name,
    employer = this.employer,
    logoUrl = this.logoUrl,
    dateStart = this.expDates.begin.toRoomString(),
    dateEnd = this.expDates.end?.toRoomString(),
    professional = this.professional,
)

fun ExperienceInformation.toLocalData(parentId: Long) = ExperienceInformationData(
    parentExperienceId = parentId, name = this.name
)

fun ExperienceWithInformation.toDomain() = experience.toDomain(informations)

fun ExperienceEntity.toDomain(informations: List<ExperienceInformationData>) = Experience(
    name = this.name,
    employer = this.employer,
    logoUrl = this.logoUrl,
    expDates = Dates(begin = this.dateStart.toJavaDate(), end = this.dateEnd?.toJavaDate()),
    professional = this.professional,
    informations = informations.map { it.toDomain() }
)

fun ExperienceInformationData.toDomain() = ExperienceInformation(
    name = this.name
)
