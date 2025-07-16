package com.adrienmandroid.composecv.feature.other.domain.model

import androidx.annotation.DrawableRes
import com.adrienmandroid.composecv.model.Dates

data class Study(
    //later : replace with string : url of the picture
    @DrawableRes val logo: Int,
    val name: String,
    val diploma: String,
    val studyDates: Dates,
    val longString: Boolean = false
)