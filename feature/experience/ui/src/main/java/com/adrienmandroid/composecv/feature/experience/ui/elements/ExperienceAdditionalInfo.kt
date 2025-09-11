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
import com.adrienmandroid.composecv.core.ui.Difference
import com.adrienmandroid.composecv.core.ui.getDifferenceToString
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.toMonthString
import java.util.Date

//Note : Text color of a text is by default onX where X is the container containing it
// (does not take into account column background)
@Composable
fun ExpAdditionalInfo(begin: Date, end: Date?, duration: Difference, employer: String?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(expHorizontalSpacing, expVerticalSpacing)
    ) {
        Text(
            text = begin.toMonthString().plus(" - ").plus(end.toMonthString()),
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = duration.getDifferenceToString(),
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
            begin = Date(1730075200000),
            end = Date(1730075200000),
            duration = Difference(3, 2),
            employer = "Employeur Lorem ipsum",
        )
    }
}
