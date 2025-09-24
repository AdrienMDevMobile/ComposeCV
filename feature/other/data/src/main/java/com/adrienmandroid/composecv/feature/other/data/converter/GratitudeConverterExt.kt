package com.adrienmandroid.composecv.feature.other.data.converter

import com.adrienmandroid.composecv.feature.other.data.local.GratitudeLocalEntity

fun GratitudeLocalEntity.toDomain() = this.text

fun String.toLocalEntity() = GratitudeLocalEntity(
    text = this
)