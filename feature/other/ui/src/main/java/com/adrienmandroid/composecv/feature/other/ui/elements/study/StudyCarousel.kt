package com.adrienmandroid.composecv.feature.other.ui.elements.study

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.carousel.CarouselPagerIndicator
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.ui.preview.data.StudyPreviewParameterData
import com.adrienmandroid.composecv.feature.other.ui.state.StudyUiState

@Composable
fun StudyCarousel(
    studies: List<StudyUiState>,
    pagerState: PagerState,
) {
    Column {
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
fun PreviewStudyCarousel() {
    val studies = StudyPreviewParameterData().studies
    ComposeCVTheme {
        StudyCarousel(studies = studies.studies, PagerState() { studies.studies.size })
    }
}

@Composable
@PreviewLightDark
fun PreviewStudyCarouselOneElement() {
    val studies = StudyPreviewParameterData().studies.studies.subList(0, 1)
    ComposeCVTheme {
        StudyCarousel(
            studies = studies,
            PagerState() { studies.size })
    }
}

@Composable
@PreviewLightDark
fun PreviewStudyCarouselMiddleElement() {
    val studies = StudyPreviewParameterData().studies
    ComposeCVTheme {
        StudyCarousel(
            studies = studies.studies,
            pagerState = PagerState(1) { studies.studies.size })
    }
}

@Composable
@PreviewLightDark
fun PreviewStudyCarouselLastElement() {
    val studies = StudyPreviewParameterData().studies
    ComposeCVTheme {
        StudyCarousel(
            studies = studies.studies,
            pagerState = PagerState(studies.studies.lastIndex) { studies.studies.size })
    }
}