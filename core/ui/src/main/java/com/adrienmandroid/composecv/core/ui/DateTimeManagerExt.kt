package com.adrienmandroid.composecv.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.adrienmandroid.composecv.core.ui.R
import com.adrienmandroid.composecv.data.model.Dates
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun Date?.toMonthString(): String =
    this?.let { SimpleDateFormat("MMMM yyyy").format(this) }
        ?: stringResource(id = R.string.exp_up_to_today)

@Composable
fun Date?.toDayString(): String =
    this?.let { SimpleDateFormat("dd MMMM yyyy").format(this) }
        ?: stringResource(id = R.string.exp_up_to_today)

fun String.toMyLong(): Long? = SimpleDateFormat("dd MMMM yyyy").parse(this)?.time

@Composable
fun Dates.getDifferenceToString(): String {
    val endDate = end ?: Date()
    val diff = kotlin.math.abs(endDate.time - begin.time)
    val diffDays = (diff / (24 * 60 * 60 * 1000)).toInt()

    val numberYears = diffDays / 365
    val numberMonths = (diffDays % 365) / 31

    return if (numberYears > 0 && numberMonths > 0) {
        stringResource(
            R.string.years_and_months,
            LocalContext.current.resources.getQuantityString(
                R.plurals.years,
                numberYears,
                numberYears
            ),
            LocalContext.current.resources.getQuantityString(
                R.plurals.months,
                numberMonths,
                numberMonths
            )
        )
    } else if (numberYears > 0) {
        LocalContext.current.resources.getQuantityString(R.plurals.years, numberYears, numberYears)
    } else if (numberMonths > 0) {
        LocalContext.current.resources.getQuantityString(
            R.plurals.months,
            numberMonths,
            numberMonths
        )
    } else {
        stringResource(R.string.exp_less_than_month)
    }
}