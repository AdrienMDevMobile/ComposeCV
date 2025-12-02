package com.adrienmandroid.composecv.feature.skills.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.navigation.compose.hiltViewModel
import com.adrienmandroid.composecv.core.ui.ErrorPage
import com.adrienmandroid.composecv.core.ui.LoadingPage
import com.adrienmandroid.composecv.core.ui.states.PageState
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.feature.skills.ui.element.SkillCard
import com.adrienmandroid.composecv.feature.skills.ui.preview.SkillsPreviewParameterData
import com.adrienmandroid.composecv.feature.skills.ui.state.SkillUiState
import com.adrienmandroid.composecv.feature.skills.ui.viewmodel.SkillViewModel

@Composable
fun SkillFragment(
    modifier: Modifier = Modifier,
    skillViewModel: SkillViewModel = hiltViewModel(),
) {
    val skills: PageState<List<SkillUiState>> by skillViewModel.skills.observeAsState(PageState.Loading)

    when (skills) {
        PageState.Loading -> LoadingPage()
        PageState.Error -> ErrorPage()
        is PageState.Content<List<SkillUiState>> -> SkillPage(
            (skills as PageState.Content<List<SkillUiState>>).value,
            modifier
        )
    }

}

@Composable
fun SkillPage(
    skills: List<SkillUiState>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        contentPadding = WindowInsets.statusBars.asPaddingValues(),
    ) {
        items(items = skills) {
            SkillCard(it)
        }
    }
}

@PreviewLightDark
@Composable
fun PreviewSkill() {
    ComposeCVTheme {
        SkillPage(SkillsPreviewParameterData.skills)
    }
}