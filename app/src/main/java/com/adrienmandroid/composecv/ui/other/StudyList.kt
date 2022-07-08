package com.adrienmandroid.composecv.ui.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.Dates
import com.adrienmandroid.composecv.data.Study
import com.adrienmandroid.composecv.ui.experience.toMonthString
import java.util.*

val studyVerticalSpacing = 10.dp

fun LazyListScope.studyList(studies: List<Study>) {
    item {
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 12.dp)
        ) {
            items(items = studies) {
                StudyCard(it, modifier = Modifier.fillParentMaxWidth())
            }
        }
    }
}

@Composable
fun StudyCard(study: Study, modifier: Modifier) {
    Card(
        modifier = modifier
            .wrapContentSize()
            .height(150.dp)
            .clip(RoundedCornerShape(25.dp))
            .padding(10.dp, 10.dp),
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.background,
    )
    {
        Image(
            painter = painterResource(study.logo),
            contentDescription = stringResource(id = study.name),
            modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp, 15.dp),
            alignment = Alignment.CenterStart,
            alpha = 0.7f
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 40.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = study.name)
            )
            Spacer(modifier = Modifier.height(studyVerticalSpacing))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = study.diploma)
            )
            Spacer(modifier = Modifier.height(studyVerticalSpacing))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = study.studyDates.begin.toMonthString().plus(" - ")
                    .plus(study.studyDates.end.toMonthString()),
            )
        }
    }
}

@Preview
@Composable
fun PreviewStudyCard() {
    StudyCard(
        study = Study(
            logo = R.drawable.image_ece,
            name = R.string.study_brighton,
            diploma = R.string.diploma_brighton,
            studyDates = Dates(
                begin = Date(1593554400000), end = Date(1641596400000)
            )
        ), modifier = Modifier
    )
}