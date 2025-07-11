package com.adrienmandroid.composecv.feature.other

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.preview.data.HobbyPreviewParameterData
import com.adrienmandroid.composecv.feature.other.preview.data.QuotePreviewParameterData
import com.adrienmandroid.composecv.feature.other.preview.data.StudyPreviewParameterData
import com.adrienmandroid.composecv.feature.other.ui.elements.Gratitudes
import com.adrienmandroid.composecv.feature.other.ui.elements.HobbyRow
import com.adrienmandroid.composecv.feature.other.ui.elements.QuoteCarousel
import com.adrienmandroid.composecv.feature.other.ui.elements.Signature
import com.adrienmandroid.composecv.feature.other.ui.elements.StudyList
import com.adrienmandroid.composecv.feature.other.ui.elements.Version
import com.adrienmandroid.composecv.feature.other.ui.elements.otherSection
import com.adrienmandroid.composecv.feature.other.viewmodel.OtherViewModel
import com.adrienmandroid.composecv.model.Hobby
import com.adrienmandroid.composecv.model.Quote
import com.adrienmandroid.composecv.model.Study
import com.adrienmandroid.composecv.model.VersionName

@Composable
fun OtherFragment(
    modifier: Modifier = Modifier,
    otherViewModel: OtherViewModel = hiltViewModel(),
) {
    val studies: List<Study> by otherViewModel.studies.observeAsState(emptyList())
    val quotes: List<Quote> by otherViewModel.quotes.observeAsState(emptyList())
    val hobbies: List<Hobby> by otherViewModel.hobbies.observeAsState(emptyList())
    val gratitude: String by otherViewModel.gratitude.observeAsState("")
    val versionName: VersionName by otherViewModel.version.observeAsState("")

    OtherScreen(studies, quotes, hobbies, gratitude, versionName, modifier)
}

@Composable
fun OtherScreen(
    studies: List<Study>,
    quotes: List<Quote>,
    hobbies: List<Hobby>,
    gratitude: String,
    versionName: VersionName,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colors.background),
        contentPadding = WindowInsets.statusBars.asPaddingValues(),
    ) {
        otherSection(
            { StudyList(studies = studies) },
            title = R.string.title_diplomas,
            firstElement = true
        )
        otherSection({ QuoteCarousel(quotes) }, title = R.string.title_quotes)
        otherSection({ HobbyRow(hobbies) }, title = R.string.title_hobbies)
        otherSection({ Gratitudes(gratitude) }, title = R.string.title_gratitude)
        otherSection({ Signature(MaterialTheme.colors.secondaryVariant) })
        otherSection({ Version(versionName) })
    }
}

@Composable
@Preview
fun PreviewOther() {
    val context = LocalContext.current

    ComposeCVTheme {
        OtherScreen(
            studies = StudyPreviewParameterData(context).studies,
            quotes = QuotePreviewParameterData.quotes,
            hobbies = HobbyPreviewParameterData(context).hobbies,
            gratitude = "Gratitude Lorem ipsum",
            versionName = "1.0.0-test"
        )
    }
}