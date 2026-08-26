package com.adrienmandroid.composecv.feature.other.ui.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.core.ui.CarouselPagerIndicator
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.ui.preview.data.StudyPreviewParameterData
import com.adrienmandroid.composecv.feature.other.ui.state.StudyUiState

val studyVerticalSpacing = 10.dp

@Composable
fun StudyList(
    studies: List<StudyUiState>,
) {
    StudyList(studies, 0)
}

@Composable
private fun StudyList(
    studies: List<StudyUiState>,
    initialPage: Int = 0
) {
    val pagerState = rememberPagerState(initialPage = initialPage) {
        studies.size
    }
    Box() {
        Column() {
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 12.dp),
            ) { page ->
                StudyCard(studies[page])
            }

            CarouselPagerIndicator(pagerState)
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.matchParentSize()
        ) {
            Button(onClick = {}) {
                Text("prev")
            }
            /*
            if (pagerState.canScrollBackward) {

            }
             */

            Button(onClick = {}) {
                Text("next")
            }
            /*
            if (pagerState.canScrollForward) {
             */
        }
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

@Composable
@PreviewLightDark
fun PreviewStudyListOneElement() {
    val studies = StudyPreviewParameterData().studies
    ComposeCVTheme {
        StudyList(studies = studies.studies.subList(0, 1))
    }
}

@Composable
@PreviewLightDark
fun PreviewStudyListLastElement() {
    val studies = StudyPreviewParameterData().studies
    ComposeCVTheme {
        StudyList(studies = studies.studies, initialPage = studies.studies.lastIndex)
    }
}