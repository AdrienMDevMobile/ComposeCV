package com.adrienmandroid.composecv.feature.other.ui.elements.study

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.CarouselArrows
import com.adrienmandroid.composecv.core.ui.R
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
            CarouselArrows(pagerState)
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