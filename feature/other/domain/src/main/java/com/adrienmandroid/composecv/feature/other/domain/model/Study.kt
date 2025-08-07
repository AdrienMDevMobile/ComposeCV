package com.adrienmandroid.composecv.feature.other.domain.model

import com.adrienmandroid.composecv.model.Dates

data class Study(
    val logoUrl: String,
    val name: String,
    val diploma: String,
    val dates: Dates,
    val isLongString: Boolean = false
)