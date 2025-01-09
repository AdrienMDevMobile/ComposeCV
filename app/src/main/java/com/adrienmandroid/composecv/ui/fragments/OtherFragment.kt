package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.dataSource.impl.HobbyDataSourceImpl
import com.adrienmandroid.composecv.data.dataSource.impl.QuoteDataImpl
import com.adrienmandroid.composecv.data.dataSource.impl.StudyDataImpl
import com.adrienmandroid.composecv.ui.other.*
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

@Composable
fun OtherFragment() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colors.background),
    )
    {
        otherSection(
            { StudyList(studies = StudyDataImpl().getData()) },
            title = R.string.title_diplomas,
            firstElement = true
        )
        otherSection({ QuoteCarousel(QuoteDataImpl()) }, title = R.string.title_quotes)
        otherSection({ HobbyRow(HobbyDataSourceImpl().getHobbies()) }, title = R.string.hobbies)
        otherSection({ Gratitudes() }, title = R.string.title_gratitude)
        otherSection({ Signature(MaterialTheme.colors.secondaryVariant) })
        otherSection({ Version() })
    }
}

@Composable
@Preview
fun PreviewOther() {
    ComposeCVTheme() {
        OtherFragment()
    }
}