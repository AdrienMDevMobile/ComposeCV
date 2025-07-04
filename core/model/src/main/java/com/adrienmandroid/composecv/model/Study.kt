package com.adrienmandroid.composecv.model

import androidx.annotation.DrawableRes

data class Study(
    //later : replace with string : url of the picture
    @DrawableRes val logo: Int,
    val name: String,
    val diploma: String,
    val studyDates: Dates,
    val longString: Boolean = false
)