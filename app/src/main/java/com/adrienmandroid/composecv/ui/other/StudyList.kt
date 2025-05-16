package com.adrienmandroid.composecv.ui.other

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.data.model.Study
import com.adrienmandroid.composecv.data.impl.StudyDataImpl
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.core.ui.theme.carouselButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

val studyVerticalSpacing = 10.dp

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StudyList(studies: List<Study>) {
    Column {
        val pagerState = rememberPagerState()

        HorizontalPager(
            count = studies.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 12.dp),
        ) { page ->
            StudyCard(studies[page])
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
            activeColor = MaterialTheme.colors.carouselButton
        )
    }
}

@Composable
@Preview
fun PreviewStudyList() {
    ComposeCVTheme {
        StudyList(studies = StudyDataImpl().getData())
    }
}