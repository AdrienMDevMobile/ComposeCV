package com.adrienmandroid.composecv.feature.data.converter

import com.adrienmandroid.composecv.feature.data.local.IconLocalEntity
import com.adrienmandroid.composecv.feature.welcome.domain.model.Icon

fun IconLocalEntity.toDomain() = when(this){
    IconLocalEntity.MAIL -> Icon.MAIL
    IconLocalEntity.LOCATION -> Icon.LOCATION
    IconLocalEntity.GITHUB -> Icon.GITHUB
    IconLocalEntity.LINKEDIN -> Icon.LINKEDIN
}

fun Icon.toLocalEntity() = when(this){
    Icon.MAIL -> IconLocalEntity.MAIL
    Icon.LOCATION -> IconLocalEntity.LOCATION
    Icon.GITHUB -> IconLocalEntity.GITHUB
    Icon.LINKEDIN -> IconLocalEntity.LINKEDIN
}