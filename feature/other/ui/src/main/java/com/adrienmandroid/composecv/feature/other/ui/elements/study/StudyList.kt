package com.adrienmandroid.composecv.feature.other.ui.elements.study

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.carousel.CarouselAccessibilityArrows
import com.adrienmandroid.composecv.core.ui.rememberIsAccessibilityEnabled
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.ui.preview.data.StudyPreviewParameterData
import com.adrienmandroid.composecv.feature.other.ui.state.StudyUiState

val studyVerticalSpacing = 10.dp

@Composable
fun StudyList(
    studies: List<StudyUiState>,
) {
    val accessOn = rememberIsAccessibilityEnabled()
    StudyList(studies, accessOn, 0)
}

@Composable
private fun StudyList(
    studies: List<StudyUiState>,
    accessOn: Boolean,
    initialPage: Int = 0,
) {
    val pagerState = rememberPagerState(initialPage = initialPage) {
        studies.size
    }
    Box {
        StudyCarousel(
            studies,
            pagerState
        )

        if (accessOn) {
            CarouselAccessibilityArrows(pagerState)
        }
    }
}

@Composable
@PreviewLightDark
fun PreviewStudyListNoAccessibility() {
    val studies = StudyPreviewParameterData().studies
    ComposeCVTheme {
        StudyList(studies = studies.studies, false)
    }
}

@Composable
@PreviewLightDark
fun PreviewStudyListMiddleElementAccessibility() {
    val studies = StudyPreviewParameterData().studies
    ComposeCVTheme {
        StudyList(studies = studies.studies, true, initialPage = 1)
    }
}