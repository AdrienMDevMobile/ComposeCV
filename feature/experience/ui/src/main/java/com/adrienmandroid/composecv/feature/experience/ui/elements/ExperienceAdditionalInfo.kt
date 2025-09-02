package com.adrienmandroid.composecv.feature.experience.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.adrienmandroid.composecv.core.ui.getDifferenceToString
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.toMonthString
import com.adrienmandroid.composecv.model.Dates
import java.util.Date

//Note : Text color of a text is by default onX where X is the container containing it
// (does not take into account column background)
@Composable
fun ExpAdditionalInfo(dates: Dates, employer: String?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(expHorizontalSpacing, expVerticalSpacing)
    ) {
        Text(
            text = dates.begin.toMonthString().plus(" - ").plus(dates.end.toMonthString()),
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = dates.getDifferenceToString(),
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
        )
        if (employer != null) {
            Text(
                text = employer,
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@PreviewLightDark
@Composable
fun PreviewExpAdditionalInfo() {
    ComposeCVTheme {
        ExpAdditionalInfo(
            dates = Dates(begin = Date(1730075200000), end = Date(1730075200000)),
            employer = "Employeur Lorem ipsum",
        )
    }
}
