package com.adrienmandroid.composecv.feature.experience.ui.elements

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.getDifferenceToString
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.model.Dates
import com.adrienmandroid.composecv.model.Experience
import com.adrienmandroid.composecv.model.ExperienceInformation
import com.adrienmandroid.composecv.model.Link
import com.adrienmandroid.composecv.core.ui.toAnnotatedString
import com.adrienmandroid.composecv.core.ui.theme.onSurfaceTitle
import com.adrienmandroid.composecv.core.ui.toMonthString
import com.adrienmandroid.composecv.core.test.R as TestingR

val expHorizontalSpacing = 10.dp
val expVerticalSpacing = 10.dp

@Composable
fun ExperienceCard(experience: Experience) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp))
            .padding(expHorizontalSpacing, expVerticalSpacing),
        elevation = if (experience.professional) {
            6.dp
        } else {
            2.dp
        },
        backgroundColor = MaterialTheme.colors.background
    )
    {
        Column(modifier = Modifier.fillMaxWidth()) {
            ExperienceHeader(experience.logo, experience.name, experience.professional)
            ExpAdditionalInfo(experience.expDates, experience.employer, experience.link)
            ExperienceInfoListItem(experience.informations)
            Spacer(modifier = Modifier.height(expVerticalSpacing))
        }
    }
}

@Composable
fun ExperienceHeader(logo: Int, @StringRes name: Int, professional: Boolean) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (professional) {
                    MaterialTheme.colors.primary
                } else {
                    MaterialTheme.colors.primaryVariant
                }
            ),
        contentAlignment = Alignment.CenterStart,
    ) {
        Row {
            Image(
                painter = painterResource(logo),
                contentDescription = stringResource(id = name),
                modifier = Modifier
                    .size(50.dp)
                    .padding(expHorizontalSpacing, 0.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurfaceTitle)
            )
            Spacer(modifier = Modifier.width(expHorizontalSpacing))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = name),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onSurfaceTitle,
                textAlign = TextAlign.Center
            )
        }

    }

}

@Composable
fun ExpAdditionalInfo(dates: Dates, @StringRes employer: Int?, link: Link?) {
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
                text = stringResource(id = employer),
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
                stringResource(id = information.name).toAnnotatedString(),
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Preview
@Composable
fun PreviewExperienceHeader() {
    ComposeCVTheme {
        Column {
            ExperienceHeader(logo = TestingR.drawable.ic_test, name = TestingR.string.test_1_word, true)
            ExperienceHeader(logo = TestingR.drawable.ic_test, name = TestingR.string.test_1_word, false)
        }

    }
}