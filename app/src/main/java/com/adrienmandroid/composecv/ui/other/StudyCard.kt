package com.adrienmandroid.composecv.ui.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.data.model.Study
import com.adrienmandroid.composecv.feature.experience.ui.elements.toMonthString
import java.util.*


@Composable
fun StudyCard(study: Study) {
    val textStyle = when(study.longString){ true -> typography.body2 false -> typography.body1 }
    Card(
        modifier = Modifier
            .fillMaxWidth()
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
            alignment = Alignment.CenterEnd,
            alpha = 0.5f
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(study.logo),
                contentDescription = stringResource(id = study.name),
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.25f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = study.name),
                    style = textStyle
                )
                Spacer(modifier = Modifier.height(studyVerticalSpacing))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = study.diploma),
                            style = textStyle
                )
                Spacer(modifier = Modifier.height(studyVerticalSpacing))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = study.studyDates.begin.toMonthString().plus(" - ")
                        .plus(study.studyDates.end.toMonthString()),
                    style = textStyle
                )
            }
        }

    }
}

/*TODO
@Preview(
    widthDp = 300,
    heightDp = 200
)
@Composable
fun PreviewStudyCard() {
    StudyCard(
        study = Study(
            logo = R.drawable.image_ece,
            name = R.string.study_brighton,
            diploma = R.string.diploma_brighton,
            studyDates = Dates(
                begin = Date(1593554400000), end = Date(1641596400000)
            ),
            longString = true
        )
    )
}*/