package com.adrienmandroid.composecv.feature.other

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.data.impl.QuoteRepositoryImpl
import com.adrienmandroid.composecv.data.impl.StudyRepositoryImpl
import com.adrienmandroid.composecv.feature.other.ui.elements.Gratitudes
import com.adrienmandroid.composecv.feature.other.ui.elements.HobbyRow
import com.adrienmandroid.composecv.feature.other.ui.elements.QuoteCarousel
import com.adrienmandroid.composecv.feature.other.ui.elements.Signature
import com.adrienmandroid.composecv.feature.other.ui.elements.StudyList
import com.adrienmandroid.composecv.feature.other.ui.elements.Version
import com.adrienmandroid.composecv.feature.other.ui.elements.otherSection
import com.adrienmandroid.composecv.feature.other.viewmodel.OtherViewModel
import com.adrienmandroid.composecv.model.Hobby
import com.adrienmandroid.composecv.core.test.R as TestingR

@Composable
fun OtherFragment(
    modifier: Modifier = Modifier,
    otherViewModel: OtherViewModel = hiltViewModel(),
) {
    val hobbies: List<Hobby> by otherViewModel.hobbies.observeAsState(emptyList())

    OtherScreen(hobbies, modifier)
}

@Composable
fun OtherScreen(
    hobbies: List<Hobby>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colors.background),
    ) {
        otherSection(
            { StudyList(studies = StudyRepositoryImpl().getData()) },
            title = R.string.title_diplomas,
            firstElement = true
        )
        otherSection({ QuoteCarousel(QuoteRepositoryImpl()) }, title = R.string.title_quotes)
        otherSection({ HobbyRow(hobbies) }, title = R.string.title_hobbies)
        otherSection({ Gratitudes() }, title = R.string.title_gratitude)
        otherSection({ Signature(MaterialTheme.colors.secondaryVariant) })
        otherSection({ Version() })
    }
}

@Composable
@Preview
fun PreviewOther() {
    val hobby = Hobby(
        TestingR.string.test_short_text_1_line,
        TestingR.drawable.img_test,
        TestingR.string.test_1_word,
    )
    ComposeCVTheme {
        OtherScreen(
            hobbies = listOf(
                hobby, hobby, hobby
            )
        )
    }
}