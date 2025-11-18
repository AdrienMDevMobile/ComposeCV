package com.adrienmandroid.composecv.feature.welcome.ui.element

import com.adrienmandroid.composecv.feature.welcome.domain.model.WelcomeIcon
import com.adrienmandroid.composecv.feature.welcome.ui.R

fun WelcomeIcon.getResourceId() = when(this){
    WelcomeIcon.MAIL -> R.drawable.email
    WelcomeIcon.LOCATION -> R.drawable.location
    WelcomeIcon.GITHUB -> R.drawable.github
    WelcomeIcon.LINKEDIN -> R.drawable.linkedin
}