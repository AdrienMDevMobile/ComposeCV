package com.adrienmandroid.composecv.ui.experience

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.ExpDates
import com.adrienmandroid.composecv.data.Experience
import com.adrienmandroid.composecv.data.Link
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.ui.theme.onSurfaceTitle


val expHorizontalSpacing = 10.dp
val expVerticalSpacing = 10.dp

@Composable
fun ExperienceCard(experience: Experience) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp))
            .padding(expHorizontalSpacing, expVerticalSpacing),
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.background
    )
    {
        Column(modifier = Modifier.fillMaxWidth()) {
            ExperienceHeader(experience.logo, experience.name)
            ExpAdditionalInfo(experience.ExpDates, experience.link)
            ExperienceInfoListItem(experience.informations)
            Spacer(modifier = Modifier.height(expVerticalSpacing))
        }
    }
}

@Composable
fun ExperienceHeader(logo: Int, name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface),
        contentAlignment = Alignment.CenterStart,
    ) {
        Row() {
            Image(
                painter = painterResource(logo),
                contentDescription = name,
                modifier = Modifier.size(50.dp).padding(expHorizontalSpacing, 0.dp)
            )
            Spacer(modifier = Modifier.width(expHorizontalSpacing))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = name,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onSurfaceTitle,
                textAlign = TextAlign.Center
            )
        }

    }

}

@Composable
fun ExpAdditionalInfo(dates: ExpDates, link: Link?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(expHorizontalSpacing, expVerticalSpacing)
    ) {
        Text(
            text = dates.begin.toMonthString().plus(" - ").plus(dates.end.toMonthString()),
            fontWeight = FontWeight.Bold
        )
        Text(text = dates.getDifferenceToString(), fontWeight = FontWeight.Bold)
        if (link != null) {
            Text(link.text)
        }
    }
}

@Composable
fun ExperienceInfoListItem(informations: List<String>) {
    informations.forEach { information ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
                .padding(expHorizontalSpacing, 0.dp)
        ) {
            Text(information)
        }
    }
}

@Preview
@Composable
fun PreviewExperienceHeader() {
    ComposeCVTheme() {
        ExperienceHeader(logo = R.drawable.home, name = "Test")
    }
}