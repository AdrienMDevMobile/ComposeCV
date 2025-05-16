package com.adrienmandroid.composecv.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Quote(@StringRes val text: Int, @StringRes val author: Int, @DrawableRes val image: Int)