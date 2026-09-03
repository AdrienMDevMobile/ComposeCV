package com.adrienmandroid.composecv.feature.other.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.adrienmandroid.composecv.core.ui.ErrorPage
import com.adrienmandroid.composecv.core.ui.LoadingPage
import com.adrienmandroid.composecv.core.ui.ShadowBelowStatusBar
import com.adrienmandroid.composecv.core.ui.states.PageState
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.ui.elements.Gratitudes
import com.adrienmandroid.composecv.feature.other.ui.elements.HobbyRow
import com.adrienmandroid.composecv.feature.other.ui.elements.Signature
import com.adrienmandroid.composecv.feature.other.ui.elements.Version
import com.adrienmandroid.composecv.feature.other.ui.elements.otherSection
import com.adrienmandroid.composecv.feature.other.ui.elements.quote.QuoteList
import com.adrienmandroid.composecv.feature.other.ui.elements.study.StudyList
import com.adrienmandroid.composecv.feature.other.ui.preview.data.OtherPreviewParameterData
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState
import com.adrienmandroid.composecv.feature.other.ui.viewmodel.OtherViewModel

@Composable
fun OtherScreen(
    modifier: Modifier = Modifier,
    otherViewModel: OtherViewModel = hiltViewModel(),
) {
    val otherComponents: PageState<List<OtherComponentUiState>> by otherViewModel.otherComponents.observeAsState(
        PageState.Loading
    )

    Box(modifier = Modifier.testTag(OTHER_SCREEN_ID)) {
        when (otherComponents) {
            PageState.Loading -> LoadingPage()
            PageState.Error -> ErrorPage()
            is PageState.Content<List<OtherComponentUiState>> -> OtherScreen(
                (otherComponents as PageState.Content<List<OtherComponentUiState>>).value,
                modifier
            )
        }
    }
}

const val OTHER_SCREEN_ID = "OTHER_SCREEN_ID"

@Composable
fun OtherScreen(
    components: List<OtherComponentUiState>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(MaterialTheme.colors.background),
        contentPadding = WindowInsets.statusBars.asPaddingValues(),
    ) {
        components.forEach { component ->
            when (component) {
                is OtherComponentUiState.GratitudeUiState -> otherSection(
                    { Gratitudes(component.values) },
                    title = R.string.title_gratitude
                )

                is OtherComponentUiState.HobbyUiStates -> otherSection(
                    { HobbyRow(component.hobbies) },
                    title = R.string.title_hobbies
                )

                is OtherComponentUiState.QuoteUiStates -> otherSection(
                    { QuoteList(component.quotes) },
                    title = R.string.title_quotes
                )

                is OtherComponentUiState.StudyUiStates -> otherSection(
                    { StudyList(studies = component.studies) },
                    title = R.string.title_diplomas,
                    firstElement = true
                )

                is OtherComponentUiState.VersionUiState -> otherSection({ Version(component.version) })
                is OtherComponentUiState.SignatureUiState -> otherSection({ Signature(MaterialTheme.colors.secondaryVariant) })
            }
        }
    }
    ShadowBelowStatusBar()
}

@Composable
@PreviewLightDark
fun PreviewOther() {
    ComposeCVTheme {
        OtherScreen(
            OtherPreviewParameterData().others
        )
    }
}