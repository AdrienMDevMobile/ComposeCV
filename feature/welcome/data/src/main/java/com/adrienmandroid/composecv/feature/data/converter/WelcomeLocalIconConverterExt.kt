package com.adrienmandroid.composecv.feature.data.converter

import com.adrienmandroid.composecv.feature.data.local.IconLocalEntity
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeIcon

fun IconLocalEntity.toDomain() = when(this){
    IconLocalEntity.MAIL -> WelcomeIcon.MAIL
    IconLocalEntity.LOCATION -> WelcomeIcon.LOCATION
    IconLocalEntity.GITHUB -> WelcomeIcon.GITHUB
    IconLocalEntity.LINKEDIN -> WelcomeIcon.LINKEDIN
}

fun WelcomeIcon.toLocalEntity() = when(this){
    WelcomeIcon.MAIL -> IconLocalEntity.MAIL
    WelcomeIcon.LOCATION -> IconLocalEntity.LOCATION
    WelcomeIcon.GITHUB -> IconLocalEntity.GITHUB
    WelcomeIcon.LINKEDIN -> IconLocalEntity.LINKEDIN
}