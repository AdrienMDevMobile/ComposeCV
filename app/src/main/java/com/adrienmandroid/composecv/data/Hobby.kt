package com.adrienmandroid.composecv.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hobby(
    @StringRes val name: Int,
    @DrawableRes val picture: Int,
    @StringRes val category: Int
)