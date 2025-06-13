package com.adrienmandroid.composecv.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hobby(
    @StringRes val name: Int,
    @DrawableRes val picture: Int,
    @StringRes val category: Int
)