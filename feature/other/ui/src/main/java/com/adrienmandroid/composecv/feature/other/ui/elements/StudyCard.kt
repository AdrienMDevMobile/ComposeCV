package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.feature.other.ui.state.StudyUiState

@Composable
fun StudyCard(
    study: StudyUiState
) {
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
        StudyContent(study)
    }
}

@Composable
fun StudyContent(
    study: StudyUiState
) {/*TODO
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

    StudyBackgroundPicture(isError, isLocalInspection, imageLoader)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        StudyForegroundPicture(
            isLoading, isError, isLocalInspection, imageLoader,
            contentDescription = study.name
        )
        Spacer(modifier = Modifier.width(10.dp))
        StudyText(
            studyName = study.name,
            diploma = study.diploma,
            dates = study.dates,
            isLongString = study.isLongString
        )
    }*/
}
/*
@Composable
fun StudyText(
    studyName: String,
    diploma: String,
    dates: Dates,
    isLongString: Boolean
) {
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

@Composable
fun StudyBackgroundPicture(
    isError: Boolean,
    isLocalInspection: Boolean,
    imageLoader: AsyncImagePainter
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.CenterEnd
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .alpha(0.5f),
            contentScale = ContentScale.Crop,
            painter = if (isError.not() && !isLocalInspection) {
                imageLoader
            } else {
                painterResource(RCoreUi.drawable.core_placeholder)
            },
            contentDescription = "@null",
        )
    }
}

@Composable
fun StudyForegroundPicture(
    isLoading: Boolean,
    isError: Boolean,
    isLocalInspection: Boolean,
    imageLoader: AsyncImagePainter,
    contentDescription: String,
) {
    LoadingBox(
        isLoading = isLoading,
        isError = isError,
        isLocalInspection = isLocalInspection,
        imageLoader = imageLoader,
        contentDescription = contentDescription,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.25f)
    )
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
            study = StudyUiState(
                logoUrl = "",
                name = context.getString(TestingR.string.test_1_word),
                diploma = context.getString(TestingR.string.test_1_word),
                dates = Dates(
                    begin = Date(1593554400000), end = Date(1641596400000)
                ),
                isLongString = true
            )
        )
    }
}*/