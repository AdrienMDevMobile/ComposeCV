package com.adrienmandroid.composecv.ui.other

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.data.Study
import com.adrienmandroid.composecv.data.dataSource.impl.StudyDataImpl
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

val studyVerticalSpacing = 10.dp

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StudyList(studies: List<Study>) {
    HorizontalPager(
        count = studies.size,
        contentPadding = PaddingValues(horizontal = 12.dp),
    ) { page ->
        StudyCard(studies[page])
    }
}

@Composable
@Preview
fun PreviewStudyList() {
    ComposeCVTheme() {
        StudyList(studies = StudyDataImpl().getData())
    }
}