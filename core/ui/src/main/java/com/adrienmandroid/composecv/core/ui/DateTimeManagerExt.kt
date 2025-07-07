package com.adrienmandroid.composecv.core.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.model.Dates
import java.text.DateFormat
import java.util.Date
import java.util.Locale

@Composable
fun Date?.toMonthString(local: Locale = Locale.getDefault(Locale.Category.FORMAT)): String =
    this?.let { DateFormat.getDateInstance(DateFormat.DEFAULT, local).format(this) }
        ?: stringResource(id = R.string.exp_up_to_today)
/*
@Composable
fun Date?.toDayString(): String =
    this?.let { SimpleDateFormat("dd MMMM yyyy").format(this) }
        ?: stringResource(id = R.string.exp_up_to_today)
        */

@Composable
fun Dates.getDifferenceToString(): String =
    getDifferenceInts().run {
        if (numberYears > 0 && numberMonths > 0) {
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
            LocalContext.current.resources.getQuantityString(
                R.plurals.years,
                numberYears,
                numberYears
            )
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

@Composable
fun Date.getDifferenceYearsToString(): String =
    Dates(this, Date()).getDifferenceInts().run {
        stringResource(
            R.string.birth_years,
            numberYears
        )
    }

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

@Preview
@Composable
fun PreviewDateManager(){
    ComposeCVTheme {
        Column {
            Text(Date(800112600000).toMonthString(local = Locale.FRANCE))
            Text(null.toMonthString(local = Locale.FRANCE))
        }
    }
}