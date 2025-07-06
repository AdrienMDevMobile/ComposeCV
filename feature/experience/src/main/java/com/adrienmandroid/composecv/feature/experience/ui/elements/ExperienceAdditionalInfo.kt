package com.adrienmandroid.composecv.feature.experience.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.core.ui.getDifferenceToString
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.toMonthString
import com.adrienmandroid.composecv.model.Dates
import com.adrienmandroid.composecv.model.Link
import java.util.Date

@Composable
fun ExpAdditionalInfo(dates: Dates, employer: String?, link: Link?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(expHorizontalSpacing, expVerticalSpacing)
    ) {
        Text(
            text = dates.begin.toMonthString().plus(" - ").plus(dates.end.toMonthString()),
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = dates.getDifferenceToString(),
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
        )
        if (employer != null) {
            Text(
                text = employer,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold,
            )
        }
        if (link != null) {
            Text(link.text)
        }
    }
}


@Preview
@Composable
fun PreviewExpAdditionalInfo() {
    ComposeCVTheme {
        ExpAdditionalInfo(
            dates = Dates(begin = Date(1730075200000), end = Date(1730075200000)),
            employer = "Employeur Lorem ipsum",
            link = null
        )
    }
}
