package com.adrienmandroid.composecv.ui.experience

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.ExpDates
import java.text.SimpleDateFormat
import java.util.*

fun Date.toMonthString(): String = SimpleDateFormat("MMMM yyyy").format(this)
fun Date.toDayString(): String = SimpleDateFormat("dd MMMM yyyy").format(this)

fun String.toMyLong(): Long? = SimpleDateFormat("dd MMMM yyyy").parse(this)?.time

@Composable
fun ExpDates.getDifferenceToString(): String {
    val diff = kotlin.math.abs(end.time - begin.time)
    val diffDays = (diff / (24 * 60 * 60 * 1000)).toInt()

    val numberYears = diffDays / 365
    val numberMonths = (diffDays % 365) / 31

    return if (numberYears > 0 && numberMonths > 0) {
        stringResource(R.string.years_and_months, numberYears, numberMonths)
    } else if (numberYears > 0) {
        stringResource(R.string.years, numberYears)
    } else if (numberMonths > 0) {
        stringResource(R.string.month, numberMonths)
    } else {
        stringResource(R.string.exp_less_than_month)
    }
}