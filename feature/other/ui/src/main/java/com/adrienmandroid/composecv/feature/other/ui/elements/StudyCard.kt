package com.adrienmandroid.composecv.feature.other.ui.elements

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.adrienmandroid.composecv.core.test.R
import com.adrienmandroid.composecv.core.ui.LoadingBox
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.toMonthString
import com.adrienmandroid.composecv.model.Dates
import com.adrienmandroid.composecv.feature.other.domain.model.Study
import java.util.Date

@Composable
fun StudyCard(study: Study) {
    var isLoading by remember { mutableStateOf(true) }
    var isError by remember { mutableStateOf(false) }
    val imageLoader = rememberAsyncImagePainter(
        model = study.logoUrl,
        onState = { state ->
            isLoading = state is AsyncImagePainter.State.Loading
            isError = state is AsyncImagePainter.State.Error
        },
    )
    val isLocalInspection = LocalInspectionMode.current


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
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterEnd
        ){
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .alpha(0.5f),
                contentScale = ContentScale.Crop,
                painter = if (isError.not() && !isLocalInspection) {
                    imageLoader
                } else {
                    painterResource(com.adrienmandroid.composecv.core.ui.R.drawable.core_placeholder)
                },
                contentDescription = study.name,
            )
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LoadingBox(
                isLoading = isLoading,
                isError = isError,
                isLocalInspection = isLocalInspection,
                imageLoader = imageLoader,
                contentDescription = study.name,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.25f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            StudyText(
                studyName = study.name,
                diploma = study.diploma,
                dates = study.dates,
                isLongString = study.isLongString
            )
        }

    }
}

@Composable
fun StudyText(
    studyName: String,
    diploma: String,
    dates: Dates,
    isLongString: Boolean
){
    val textStyle = when (isLongString) {
        true -> typography.body2
        false -> typography.body1
    }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = studyName,
            style = textStyle
        )
        Spacer(modifier = Modifier.height(studyVerticalSpacing))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = diploma,
            style = textStyle
        )
        Spacer(modifier = Modifier.height(studyVerticalSpacing))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = dates.begin.toMonthString().plus(" - ")
                .plus(dates.end.toMonthString()),
            style = textStyle
        )
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    widthDp = 300,
    heightDp = 200
)
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
                logoUrl = "",
                name = context.getString(R.string.test_1_word),
                diploma = context.getString(R.string.test_1_word),
                dates = Dates(
                    begin = Date(1593554400000), end = Date(1641596400000)
                ),
                isLongString = true
            )
        )
    }
}