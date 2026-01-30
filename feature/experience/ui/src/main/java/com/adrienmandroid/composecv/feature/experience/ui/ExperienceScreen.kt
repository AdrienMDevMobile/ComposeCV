package com.adrienmandroid.composecv.feature.experience.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.adrienmandroid.composecv.feature.experience.ui.elements.ExperienceCard
import com.adrienmandroid.composecv.feature.experience.ui.preview.ExperiencesPreviewParameterData
import com.adrienmandroid.composecv.feature.experience.ui.state.ExperienceUiState
import com.adrienmandroid.composecv.feature.experience.ui.viewmodel.ExperienceViewmodel

@Composable
fun ExperienceScreen(
    modifier: Modifier = Modifier,
    experienceViewmodel: ExperienceViewmodel = hiltViewModel()
) {
    val experiences: PageState<List<ExperienceUiState>> by experienceViewmodel.experiences.observeAsState(
        PageState.Loading
    )

    Box(modifier = Modifier.testTag(EXPERIENCE_SCREEN_ID)) {
        when (experiences) {
            PageState.Loading -> LoadingPage()
            PageState.Error -> ErrorPage()
            is PageState.Content<List<ExperienceUiState>> -> ExperiencePage(
                (experiences as PageState.Content<List<ExperienceUiState>>).value,
                modifier
            )
        }
    }
}

const val EXPERIENCE_SCREEN_ID = "EXPERIENCE_SCREEN_ID"

@Composable
fun ExperiencePage(
    experiences: List<ExperienceUiState>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.background(MaterialTheme.colors.background),
        contentPadding = WindowInsets.statusBars.asPaddingValues(),
    ) {
        items(items = experiences) {
            ExperienceCard(experience = it)
        }
    }
    ShadowBelowStatusBar()
}

@Composable
@PreviewLightDark
fun PrevExperiencePage() {
    ComposeCVTheme {
        ExperiencePage(ExperiencesPreviewParameterData.experiences)
    }
}