package com.adrienmandroid.composecv.feature.experience.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.getDifferenceToString
import com.adrienmandroid.composecv.core.ui.toMonthString
import com.adrienmandroid.composecv.model.Dates
import com.adrienmandroid.composecv.model.ExperienceInformation
import com.adrienmandroid.composecv.model.Link

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

@Composable
fun ExperienceInfoListItem(informations: List<ExperienceInformation>) {
    informations.forEach { information ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
                .padding(expHorizontalSpacing, 0.dp)
        ) {
            Text(
                //TODO comprendre cela : stringResource(id = information.name).toAnnotatedString
                information.name,
                style = MaterialTheme.typography.body1
            )
        }
    }
}