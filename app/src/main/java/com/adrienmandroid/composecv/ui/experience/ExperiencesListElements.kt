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


@Composable
fun ExperienceCard(experience: Experience) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(25.dp))
            .padding(10.dp),
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.background
    )
    {
        Column(modifier = Modifier.fillMaxWidth()) {
            ExperienceHeader(experience.logo, experience.name)
            ExpAdditionalInfo(experience.ExpDates, experience.link)
            experience.informations.forEach { information ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                ) {
                    ExperienceInfoListItem(information)
                }
            }
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
                modifier = Modifier.height(40.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ) {
        Text(text = dates.begin.toMonthString(), fontWeight = FontWeight.Bold)
        Text(text = dates.end.toMonthString(), fontWeight = FontWeight.Bold)
        if (link != null) {
            Text(link.text)
        }
    }
}

@Composable
fun ExperienceInfoListItem(information: String) {
    Text(information)
}

@Preview
@Composable
fun PreviewExperienceHeader() {
    ComposeCVTheme() {
        ExperienceHeader(logo = R.drawable.home, name = "Test")
    }
}