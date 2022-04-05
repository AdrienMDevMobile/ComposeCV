package com.adrienmandroid.composecv.ui.fragments

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.ui.experience.ExpDates
import com.adrienmandroid.composecv.ui.experience.Experience
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme
import com.adrienmandroid.composerandom.experience.ExpAdditionalInfo
import com.adrienmandroid.composerandom.experience.ExperienceHeader
import com.adrienmandroid.composerandom.experience.ExperienceInfoListItem
import java.util.*

@ExperimentalMaterialApi
@Composable
fun ExperienceFragment() {

    ContactsList(experiences = experiences)

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactsList(experiences : List<Experience>) {
    LazyColumn {
        experiences.forEach { experience ->
            stickyHeader {
                Box(modifier = Modifier.fillMaxWidth().background(Color.Blue)){
                    ExperienceHeader(experience.logo, experience.name)
                }

            }

            item {
                Box(modifier = Modifier.fillMaxWidth().background(Color.Green)) {
                    ExpAdditionalInfo(experience.ExpDates, experience.link)
                }
            }
            items(experience.informations) { information ->
                Box(modifier = Modifier.fillMaxWidth().background(Color.Green)) {
                    ExperienceInfoListItem(information)
                }
            }
        }
    }
}

val experiences = listOf(Experience(name = "Natixis", logo = R.drawable.home, ExpDates = ExpDates(
    Date(), Date()
) , informations =  listOf("Info1", "Info2"))
    , Experience(name = "S&H", logo = R.drawable.home, ExpDates = ExpDates(Date(), Date()) , informations =  listOf("Info3", "Info4", "Info5"))
    , Experience(name = "S&H", logo = R.drawable.home, ExpDates = ExpDates(Date(), Date()) , informations =  listOf("Info3", "Info4", "Info5"))
    , Experience(name = "S&H", logo = R.drawable.home, ExpDates = ExpDates(Date(), Date()) , informations =  listOf("Info3", "Info4", "Info6"))
    , Experience(name = "S&H", logo = R.drawable.home, ExpDates = ExpDates(Date(), Date()) , informations =  listOf("Info3", "Info4", "Info7"))
    , Experience(name = "S&H", logo = R.drawable.home, ExpDates = ExpDates(Date(), Date()) , informations =  listOf("Info3", "Info4", "Info8"))
    , Experience(name = "S&H", logo = R.drawable.home, ExpDates = ExpDates(Date(), Date()) , informations =  listOf("Info3", "Info4", "Info9"))
    , Experience(name = "S&H", logo = R.drawable.home, ExpDates = ExpDates(Date(), Date()) , informations =  listOf("Info3", "Info4", "Info10"))
)


@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun previewExp(){
    ComposeCVTheme {
        ExperienceFragment()
    }
}