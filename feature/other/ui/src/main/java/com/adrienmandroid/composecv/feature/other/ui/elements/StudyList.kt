package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.CarouselPagerIndicator
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.ui.preview.data.StudyPreviewParameterData
import com.adrienmandroid.composecv.feature.other.ui.state.StudyUiState

val studyVerticalSpacing = 10.dp

@Composable
fun StudyList(studies: List<StudyUiState>) {
    Column {
        val pagerState = rememberPagerState {
            studies.size
        }

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 12.dp),
        ) { page ->
            StudyCard(studies[page])
        }
        CarouselPagerIndicator(pagerState)

    }
}

@Composable
@PreviewLightDark
fun PreviewStudyList() {
    val studies = StudyPreviewParameterData().studies
    ComposeCVTheme {
        StudyList(studies = studies.studies)
    }
}