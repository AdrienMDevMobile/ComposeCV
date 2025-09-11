package com.adrienmandroid.composecv.core.ui

import com.adrienmandroid.composecv.model.Dates
import java.util.Date

fun Dates.getDifferenceInts(): Difference {
    val endDate = end ?: Date()
    val diff = kotlin.math.abs(endDate.time - begin.time)
    val diffDays = (diff / (24 * 60 * 60 * 1000)).toInt()

    val numberYears = diffDays / 365
    //Not exact because every month are not 31 days, but that will be enough
    val numberMonths = (diffDays % 365) / 31

    return Difference(numberYears = numberYears, numberMonths = numberMonths)
}

data class Difference(val numberYears: Int, val numberMonths: Int)