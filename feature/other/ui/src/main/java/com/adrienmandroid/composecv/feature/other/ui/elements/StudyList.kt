package com.adrienmandroid.composecv.feature.other.ui.elements

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.AccessibilityManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.core.content.getSystemService
import com.adrienmandroid.composecv.core.ui.CarouselPagerIndicator
import com.adrienmandroid.composecv.core.ui.R
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
fun CarrousselArrows(
    forward: Boolean
) {
    Button(
        onClick = {},
        modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
    ) {
        Icon(
            painter = painterResource(
                if (forward)
                    R.drawable.chevron_forward
                else R.drawable.chevron_backward
            ),
            contentDescription = "Next",
            modifier = Modifier.size(24.dp)
        )
    }
}

@Composable
private fun PlaceHolderForSpacer() {
    Box {}
}

@Composable
private fun StudyList(
    studies: List<StudyUiState>,
    initialPage: Int = 0
) {
    val pagerState = rememberPagerState(initialPage = initialPage) {
        studies.size
    }
    Box {
        Column {
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 12.dp),
            ) { page ->
                StudyCard(studies[page])
            }

            CarouselPagerIndicator(pagerState)
        }
        //Uniquement si accessibility est on

        val resources = LocalContext.current.getSystemService(Context.ACCESSIBILITY_SERVICE) as android.view.accessibility.AccessibilityManager
        val accessOn = remember(resources) {
            resources.isEnabled && resources.isTouchExplorationEnabled
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.matchParentSize()
        ) {
            if (pagerState.canScrollBackward) {
                CarrousselArrows(forward = false)
            } else {
                PlaceHolderForSpacer()
            }

            if (pagerState.canScrollForward) {
                CarrousselArrows(forward = true)
            } else {
                PlaceHolderForSpacer()
            }
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
fun PreviewStudyListMiddleElement() {
    val studies = StudyPreviewParameterData().studies
    ComposeCVTheme {
        StudyList(studies = studies.studies, initialPage = 1)
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