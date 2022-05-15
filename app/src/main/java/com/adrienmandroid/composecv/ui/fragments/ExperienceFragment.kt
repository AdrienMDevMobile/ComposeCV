package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adrienmandroid.composecv.data.Experience
import com.adrienmandroid.composecv.data.dataSource.impl.ExperienceDataImpl
import com.adrienmandroid.composecv.ui.experience.ExpAdditionalInfo
import com.adrienmandroid.composecv.ui.experience.ExperienceHeader
import com.adrienmandroid.composecv.ui.experience.ExperienceInfoListItem
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme
import com.adrienmandroid.composecv.ui.theme.composableBackground

@ExperimentalMaterialApi
@Composable
fun ExperienceFragment(experiences: List<Experience>) {
    ExperiencesList(experiences = experiences)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExperiencesList(experiences: List<Experience>) {
    LazyColumn(modifier = Modifier.background(MaterialTheme.colors.composableBackground)) {
        experiences.forEach { experience ->
            item {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillParentMaxWidth()
                                .background(MaterialTheme.colors.background)
                        ) {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                ExperienceHeader(experience.logo, experience.name)
                                ExpAdditionalInfo(experience.ExpDates, experience.link)
                                experience.informations.forEach { information ->
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(0.9f)
                                            .background(MaterialTheme.colors.background)
                                    ) {
                                        ExperienceInfoListItem(information)
                                    }
                                }
                            }
                        }

                    }
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