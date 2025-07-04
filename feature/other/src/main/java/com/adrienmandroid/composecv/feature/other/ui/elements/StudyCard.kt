package com.adrienmandroid.composecv.feature.other.ui.elements

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.toMonthString
import com.adrienmandroid.composecv.model.Dates
import com.adrienmandroid.composecv.model.Study
import java.util.Date
import com.adrienmandroid.composecv.core.test.R as TestingR

@Composable
fun StudyCard(study: Study) {
    val textStyle = when (study.longString) {
        true -> typography.body2
        false -> typography.body1
    }
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
            contentDescription = study.name,
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
                contentDescription = study.name,
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
                    text = study.name,
                    style = textStyle
                )
                Spacer(modifier = Modifier.height(studyVerticalSpacing))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = study.diploma,
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

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    widthDp = 300,
    heightDp = 200
)
@Composable
fun PreviewStudyCard() {
    val context = LocalContext.current
    ComposeCVTheme {
        StudyCard(
            study = Study(
                logo = TestingR.drawable.ic_test,
                name = context.getString(R.string.test_1_word),
                diploma = context.getString(R.string.test_1_word),
                studyDates = Dates(
                    begin = Date(1593554400000), end = Date(1641596400000)
                ),
                longString = true
            )
        )
    }
}