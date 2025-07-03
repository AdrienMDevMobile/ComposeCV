package com.adrienmandroid.composecv.model

import androidx.annotation.DrawableRes

data class Hobby(
    val name: String,
    //Later : replace with URL string of the picture
    @DrawableRes val picture: Int,
    val category: String
)