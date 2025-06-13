package com.adrienmandroid.composecv.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Study(
    @DrawableRes val logo: Int,
    @StringRes val name: Int,
    @StringRes val diploma: Int,
    val studyDates: Dates,
    val longString: Boolean = false
)