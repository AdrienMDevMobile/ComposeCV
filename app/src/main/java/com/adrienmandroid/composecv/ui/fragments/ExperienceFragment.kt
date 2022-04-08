package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.data.Experience
import com.adrienmandroid.composecv.data.dataSource.impl.ExperienceDataImpl
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme
import com.adrienmandroid.composerandom.experience.ExpAdditionalInfo
import com.adrienmandroid.composerandom.experience.ExperienceHeader
import com.adrienmandroid.composerandom.experience.ExperienceInfoListItem

@ExperimentalMaterialApi
@Composable
fun ExperienceFragment(experiences: List<Experience>) {

    ContactsList(experiences = experiences)

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactsList(experiences: List<Experience>) {
    LazyColumn {
        experiences.forEach { experience ->
            stickyHeader {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.primary)
                ) {
                    ExperienceHeader(experience.logo, experience.name)
                }

            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                ) {
                    ExpAdditionalInfo(experience.ExpDates, experience.link)
                }
            }
            items(experience.informations) { information ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.background)
                ) {
                    ExperienceInfoListItem(information)
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun previewExp() {
    ComposeCVTheme {
        ExperienceFragment(ExperienceDataImpl().getExperiences())
    }
}