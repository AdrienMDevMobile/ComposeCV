package com.adrienmandroid.composecv.data.dataSource.impl

import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.Dates
import com.adrienmandroid.composecv.data.Experience
import com.adrienmandroid.composecv.data.ExperienceInformation
import com.adrienmandroid.composecv.data.dataSource.ExperienceData
import java.util.*

class ExperienceDataImpl : ExperienceData {
    override fun getExperiences(): List<Experience> = listOf(
        Experience(
            name = R.string.exp_astek_name,
            employer = R.string.exp_astek_employer,
            logo = R.drawable.ic_exp_astek,
            ExpDates = Dates(begin = Date(1631052000000), end = null),
            informations = listOf(
                ExperienceInformation(R.string.exp_info_android),
                ExperienceInformation(R.string.exp_info_git_team),
                ExperienceInformation(R.string.exp_info_ios_back),
                ExperienceInformation(R.string.exp_info_spec),
                ExperienceInformation(R.string.exp_info_design),
                ExperienceInformation(R.string.exp_info_apply_rule),
                ExperienceInformation(R.string.exp_info_supp_monitoring_analysis),
                ExperienceInformation(R.string.exp_info_layout_data_binding),
                ExperienceInformation(R.string.exp_info_navigation_graph),
                ExperienceInformation(R.string.exp_info_ei_compose_hilt)
            )
        ),
        Experience(
            name = R.string.exp_spending_name,
            logo = R.drawable.ic_spending,
            ExpDates = Dates(begin = Date(1664575200000), end = Date(1672614000000)),
            informations = listOf(
                ExperienceInformation(R.string.exp_info_compose),
                ExperienceInformation(R.string.exp_info_room),
                ExperienceInformation(R.string.exp_info_data_store),
                ExperienceInformation(R.string.exp_info_pagination),
                ExperienceInformation(R.string.exp_info_modification_standart)
            )
        ),
        Experience(
            name = R.string.exp_cv_name,
            logo = R.drawable.ic_launcher,
            ExpDates = Dates(begin = Date(1645052400000), end = null),
            informations = listOf(
                ExperienceInformation(R.string.exp_info_compose),
                ExperienceInformation(R.string.exp_info_plural),
                ExperienceInformation(R.string.exp_info_mvvm_recommandation),
                ExperienceInformation(R.string.exp_info_collab),
                ExperienceInformation(R.string.exp_info_canvas),
                ExperienceInformation(R.string.exp_info_ddui),
                ExperienceInformation(R.string.exp_info_flavor)
            )
        ),
        Experience(
            name = R.string.exp_fdc_name,
            logo = R.drawable.ic_exp_fresque,
            ExpDates = Dates(begin = Date(1593554400000), end = Date(1641596400000)),
            informations = listOf(
                ExperienceInformation(R.string.exp_info_android_kotlin),
                ExperienceInformation(R.string.exp_info_fdc_feature),
                ExperienceInformation(R.string.exp_info_unit_test),
                ExperienceInformation(R.string.exp_info_dependency_injection),
                ExperienceInformation(R.string.exp_info_mvvm),
                ExperienceInformation(R.string.exp_info_library_search),
                ExperienceInformation(R.string.exp_info_jetpack)
            )
        ),
        Experience(
            name = R.string.exp_sh_name,
            employer = R.string.exp_sh_employer,
            logo = R.drawable.ic_exp_sh,
            ExpDates = Dates(begin = Date(1572562800000), end = Date(1590962400000)),
            informations = listOf(
                ExperienceInformation(R.string.exp_info_sh_update),
                ExperienceInformation(R.string.exp_info_spec),
                ExperienceInformation(R.string.exp_info_commentary),
                ExperienceInformation(R.string.exp_info_sh_environement),
                ExperienceInformation(R.string.exp_info_sh_new)
            )
        ),
        Experience(
            name = R.string.exp_natixis_name,
            employer = R.string.exp_natixis_employer,
            logo = R.drawable.ic_exp_natixis,
            ExpDates = Dates(begin = Date(1472680800000), end = Date(1559340000000)),
            informations = listOf(
                ExperienceInformation(R.string.exp_info_nat_autonomy),
                ExperienceInformation(R.string.exp_info_nat_analysis),
                ExperienceInformation(R.string.exp_info_nat_test)

            )
        )
    )
}