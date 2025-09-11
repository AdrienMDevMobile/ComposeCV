package com.adrienmandroid.composecv.core.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalResources
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
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
fun Difference.getDifferenceToString(): String =
    if (numberYears > 0 && numberMonths > 0) {
        stringResource(
            R.string.years_and_months,
            LocalResources.current.getQuantityString(
                R.plurals.years,
                numberYears,
                numberYears
            ),
            LocalResources.current.getQuantityString(
                R.plurals.months,
                numberMonths,
                numberMonths
            )
        )
    } else if (numberYears > 0) {
        LocalResources.current.getQuantityString(
            R.plurals.years,
            numberYears,
            numberYears
        )
    } else if (numberMonths > 0) {
        LocalResources.current.getQuantityString(
            R.plurals.months,
            numberMonths,
            numberMonths
        )
    } else {
        stringResource(R.string.exp_less_than_month)
    }

@Composable
fun Difference.getDifferenceYearsToString(): String =
    stringResource(
        R.string.birth_years,
        numberYears
    )

@PreviewLightDark
@Composable
fun PreviewDateManager() {
    ComposeCVTheme {
        Column {
            Text(Date(800112600000).toMonthString(local = Locale.FRANCE))
            Text(null.toMonthString(local = Locale.FRANCE))
        }
    }
}