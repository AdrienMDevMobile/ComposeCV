package com.adrienmandroid.composecv.data.model

import androidx.annotation.DrawableRes

//The screen and bottomBar element informations
data class BottomNavElement(
    val route: String,
    val name: String?,
    @DrawableRes val imageSelected: Int,
    @DrawableRes val imageUnSelected: Int,
)