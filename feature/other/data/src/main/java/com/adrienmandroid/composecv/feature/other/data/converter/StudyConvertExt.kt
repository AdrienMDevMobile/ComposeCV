package com.adrienmandroid.composecv.feature.other.data.converter

import com.adrienmandroid.composecv.data.local.toJavaDate
import com.adrienmandroid.composecv.data.local.toRoomString
import com.adrienmandroid.composecv.feature.other.data.local.StudyLocalEntity
import com.adrienmandroid.composecv.feature.other.data.remote.StudyRemoteBody
import com.adrienmandroid.composecv.feature.other.domain.model.Study
import com.adrienmandroid.composecv.model.Dates
import java.util.Date

fun StudyLocalEntity.toDomain() = Study(
    logoUrl = this.logoUrl,
    name = this.name,
    diploma = this.diploma,
    dates = Dates(begin = this.dateStart.toJavaDate(), end = this.dateEnd?.toJavaDate()),
    isLongString = this.isLongString
)

fun Study.toLocalEntity() = StudyLocalEntity(
    logoUrl = this.logoUrl,
    name = this.name,
    diploma = this.diploma,
    dateStart = this.dates.begin.toRoomString(),
    dateEnd = this.dates.end?.toRoomString(),
    isLongString = this.isLongString
)

fun StudyRemoteBody.toDomain() = Study(
    logoUrl = this.logoUrl,
    name = this.name,
    diploma = this.diploma,
    dates = Dates(Date(this.dates.begin), this.dates.end?.let { Date(it) } ?: null),
    isLongString = this.isLongString
)
