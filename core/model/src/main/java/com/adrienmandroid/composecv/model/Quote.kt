package com.adrienmandroid.composecv.model

import androidx.annotation.DrawableRes

data class Quote(
    val text: String,
    val author: String,
    //later : pass the image as an URL
    @DrawableRes val image: Int
)