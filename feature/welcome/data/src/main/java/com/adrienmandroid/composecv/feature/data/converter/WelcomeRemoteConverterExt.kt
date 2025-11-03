package com.adrienmandroid.composecv.feature.data.converter

import com.adrienmandroid.composecv.feature.data.remote.WelcomeRemoteElementBody
import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeBodyElement

fun WelcomeRemoteElementBody.toDomain() : WelcomeBodyElement? = when(type){
    "WelcomeImage" -> WelcomeBodyElement.WelcomeImage(source = image, description = text)
    else -> null
}