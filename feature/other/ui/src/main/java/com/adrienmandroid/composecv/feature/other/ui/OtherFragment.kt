package com.adrienmandroid.composecv.feature.other.ui

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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.navigation.compose.hiltViewModel
import com.adrienmandroid.composecv.core.ui.LoadingPage
import com.adrienmandroid.composecv.core.ui.states.UiStates
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.other.ui.elements.HobbyRow
import com.adrienmandroid.composecv.feature.other.ui.elements.QuoteCarousel
import com.adrienmandroid.composecv.feature.other.ui.elements.StudyList
import com.adrienmandroid.composecv.feature.other.ui.elements.otherSection
import com.adrienmandroid.composecv.feature.other.ui.preview.data.HobbyPreviewParameterData
import com.adrienmandroid.composecv.feature.other.ui.preview.data.QuotePreviewParameterData
import com.adrienmandroid.composecv.feature.other.ui.preview.data.StudyPreviewParameterData
import com.adrienmandroid.composecv.feature.other.ui.state.OtherComponentUiState
import com.adrienmandroid.composecv.feature.other.ui.viewmodel.OtherViewModel

@Composable
fun OtherFragment(
    modifier: Modifier = Modifier,
    otherViewModel: OtherViewModel = hiltViewModel(),
) {
    val otherComponents: UiStates<List<OtherComponentUiState>> by otherViewModel.otherComponents.observeAsState(
        UiStates.Loading
    )

    when (otherComponents) {
        UiStates.Loading -> LoadingPage()
        is UiStates.Success<List<OtherComponentUiState>> -> OtherScreen(
            (otherComponents as UiStates.Success<List<OtherComponentUiState>>).value,
            modifier
        )
    }
}

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
                is OtherComponentUiState.GratitudeUiState -> {}//TODO
                is OtherComponentUiState.HobbyUiStates -> otherSection(
                    { HobbyRow(component.hobbies) },
                    title = R.string.title_hobbies
                )

                is OtherComponentUiState.QuoteUiStates -> otherSection(
                    { QuoteCarousel(component.quotes) },
                    title = R.string.title_quotes
                )

                is OtherComponentUiState.StudyUiStates -> otherSection(
                    { StudyList(studies = component.studies) },
                    title = R.string.title_diplomas,
                    firstElement = true
                )

                is OtherComponentUiState.VersionUiState -> {} //TODO
            }
        }


        //otherSection({ Gratitudes(gratitude) }, title = R.string.title_gratitude)
        //otherSection({ Signature(MaterialTheme.colors.secondaryVariant) })
        //otherSection({ Version(versionName) })
    }
}

/*TODO
@Composable
@PreviewLightDark
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
}*/