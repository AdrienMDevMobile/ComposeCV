package com.adrienmandroid.composecv.data.dataSource.impl

import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.ExpDates
import com.adrienmandroid.composecv.data.Experience
import com.adrienmandroid.composecv.data.dataSource.ExperienceData
import java.util.*

class ExperienceDataImpl : ExperienceData {
    override fun getExperiences(): List<Experience> = listOf(
        Experience(name = "Natixis", logo = R.drawable.home, ExpDates = ExpDates(
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
}