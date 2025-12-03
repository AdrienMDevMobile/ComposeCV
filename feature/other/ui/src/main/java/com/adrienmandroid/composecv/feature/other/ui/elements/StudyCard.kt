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
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import coil3.compose.SubcomposeAsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.allowHardware
import coil3.request.crossfade
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.toMonthString
import com.adrienmandroid.composecv.feature.other.ui.state.StudyUiState
import com.adrienmandroid.composecv.model.Dates
import java.util.Date
import com.adrienmandroid.composecv.core.test.R as TestingR

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
    ) {
        StudyContent(study)
    }
}

@Composable
fun StudyContent(
    study: StudyUiState
) {
    val context = LocalPlatformContext.current

    val model = ImageRequest
        .Builder(context)
        .data(study.logoUrl)
        .crossfade(true)
        .memoryCachePolicy(CachePolicy.ENABLED).diskCachePolicy(CachePolicy.ENABLED)
        .allowHardware(false) // Better compatibility
        .build()

    SubcomposeAsyncImage(
        model = model,
        contentDescription = study.diploma,
        modifier = Modifier.fillMaxSize(),
        success = { successState ->
            StudyBackgroundPicture(successState.painter)
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 10.dp, vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                StudyForegroundPicture(
                    successState.painter, contentDescription = study.name
                )
                Spacer(modifier = Modifier.width(10.dp))
                StudyText(
                    studyName = study.name,
                    diploma = study.diploma,
                    dates = study.dates,
                    isLongString = study.isLongString
                )
            }
        },
        loading = {
            Box(
                modifier = Modifier.padding(10.dp),
                contentAlignment = Alignment.Center,
            ) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.secondary,
                )
            }
        },
        error = {
            StudyText(
                studyName = study.name,
                diploma = study.diploma,
                dates = study.dates,
                isLongString = study.isLongString
            )
        })
}

@Composable
fun StudyText(
    studyName: String, diploma: String, dates: Dates, isLongString: Boolean
) {
    val textStyle = when (isLongString) {
        true -> typography.body2
        false -> typography.body1
    }
    Column(
        modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(), text = studyName, style = textStyle
        )
        Spacer(modifier = Modifier.height(studyVerticalSpacing))
        Text(
            modifier = Modifier.fillMaxWidth(), text = diploma, style = textStyle
        )
        Spacer(modifier = Modifier.height(studyVerticalSpacing))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = dates.begin.toMonthString().plus(" - ").plus(dates.end.toMonthString()),
            style = textStyle
        )
    }
}

@Composable
fun StudyBackgroundPicture(
    painter: Painter
) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .alpha(0.5f),
            contentScale = ContentScale.Crop,
            painter = painter,
            contentDescription = "@null",
        )
    }
}

@Composable
fun StudyForegroundPicture(
    painter: Painter, contentDescription: String, colorFilter: ColorFilter? = null
) {
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.25f),
        contentScale = ContentScale.Fit,
        colorFilter = colorFilter,
    )
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO, widthDp = 300, heightDp = 200
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, widthDp = 300, heightDp = 200
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
            )
        )
    }
}