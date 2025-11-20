package com.adrienmandroid.composecv.feature.other.data.converter

import com.adrienmandroid.composecv.feature.other.data.local.HobbyLocalEntity
import com.adrienmandroid.composecv.feature.other.data.remote.elements.HobbyRemoteBody
import com.adrienmandroid.composecv.feature.other.domain.model.Hobby

fun HobbyLocalEntity.toDomain() = Hobby(
    name = this.name,
    pictureUrl = this.pictureUrl,
    category = this.category
)

fun Hobby.toLocalEntity() = HobbyLocalEntity(
    name = this.name,
    pictureUrl = this.pictureUrl,
    category = this.category
)

fun HobbyRemoteBody.toDomain() = Hobby(
    name = this.name,
    pictureUrl = this.pictureUrl,
    category = this.category
)