package com.adrienmandroid.composecv.ui.other

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.Dates
import com.adrienmandroid.composecv.data.Study
import com.adrienmandroid.composecv.data.dataSource.impl.StudyDataImpl
import com.adrienmandroid.composecv.ui.experience.toMonthString
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import java.util.*

val studyVerticalSpacing = 10.dp

@OptIn(ExperimentalPagerApi::class)
@Composable
fun StudyList(studies: List<Study>) {
    /*
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 12.dp)
    ) {
        items(items = studies) {
            StudyCard(it, modifier = Modifier.fillParentMaxWidth())
        }
    } */

    HorizontalPager(
        count = studies.size,
        contentPadding = PaddingValues(horizontal = 12.dp),
    ) { page ->
        StudyCard(studies[page])
    }
}

@Composable
@Preview
fun previewStudyList(){
    ComposeCVTheme() {
        StudyList(studies = StudyDataImpl().getData())
    }
}