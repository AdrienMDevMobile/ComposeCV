package com.adrienmandroid.composecv.feature.welcome.ui.element

import com.adrienmandroid.composecv.feature.welcome.domain.model.Icon
import com.adrienmandroid.composecv.feature.welcome.ui.R

fun Icon.getId() = when(this){
    Icon.MAIL -> R.drawable.email
    Icon.LOCATION -> R.drawable.location
    Icon.GITHUB -> R.drawable.github
    Icon.LINKEDIN -> R.drawable.linkedin
}