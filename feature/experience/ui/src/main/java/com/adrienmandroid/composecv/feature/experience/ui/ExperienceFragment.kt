package com.adrienmandroid.composecv.feature.experience.ui

import androidx.compose.foundation.background
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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.navigation.compose.hiltViewModel
import com.adrienmandroid.composecv.core.ui.LoadingPage
import com.adrienmandroid.composecv.core.ui.states.UiStates
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.experience.ui.elements.ExperienceCard
import com.adrienmandroid.composecv.feature.experience.ui.preview.ExperiencesPreviewParameterData
import com.adrienmandroid.composecv.feature.experience.ui.state.ExperienceUiState
import com.adrienmandroid.composecv.feature.experience.ui.viewmodel.ExperienceViewmodel

@Composable
fun ExperienceFragment(
    modifier: Modifier = Modifier,
    experienceViewmodel: ExperienceViewmodel = hiltViewModel()
) {
    val experiences: UiStates<List<ExperienceUiState>> by experienceViewmodel.experiences.observeAsState(
        UiStates.Loading
    )

    when (experiences) {
        UiStates.Loading -> LoadingPage()
        is UiStates.Success<List<ExperienceUiState>> -> ExperiencePage(
            (experiences as UiStates.Success<List<ExperienceUiState>>).value,
            modifier
        )
    }
}

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
}

@Composable
@PreviewLightDark
fun PrevExpFragment() {
    ComposeCVTheme {
        ExperiencePage(ExperiencesPreviewParameterData.experiences)
    }
}