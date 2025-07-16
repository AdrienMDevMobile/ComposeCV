package com.adrienmandroid.composecv.feature.experience.data

import android.content.Context
import com.adrienmandroid.composecv.data.R
import com.adrienmandroid.composecv.feature.experience.domain.model.Experience
import com.adrienmandroid.composecv.feature.experience.domain.model.ExperienceInformation
import com.adrienmandroid.composecv.feature.experience.domain.repository.ExperienceRepository
import com.adrienmandroid.composecv.model.Dates
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Date
import javax.inject.Inject

class ExperienceRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : ExperienceRepository {
    override fun getExperiences(): List<Experience> = listOf(
        Experience(
            name = context.getString(R.string.exp_off_name),
            employer = context.getString(R.string.exp_astek_employer),
            logo = R.drawable.ic_exp_astek,
            expDates = Dates(begin = Date(1730075200000), end = null),
            professional = true,
            informations = listOf(
                ExperienceInformation(
                    context.getString(R.string.exp_info_off)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_off_autonomous)
                ),
            )
        ),
        Experience(
            name = context.getString(R.string.exp_astek_name),
            employer = context.getString(R.string.exp_astek_employer),
            logo = R.drawable.ic_exp_astek,
            expDates = Dates(begin = Date(1631052000000), end = Date(1728075200000)),
            professional = true,
            informations = listOf(
                ExperienceInformation(
                    context.getString(R.string.exp_info_android)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_git_team)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_ios_back)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_spec)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_design)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_apply_rule)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_supp_monitoring_analysis)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_layout_data_binding)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_navigation_graph)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_ei_compose_hilt)
                )
            )
        ),
        Experience(
            name = context.getString(R.string.exp_cv_name),
            logo = R.drawable.ic_my_logo,
            expDates = Dates(begin = Date(1645052400000), end = null),
            professional = false,
            informations = listOf(
                ExperienceInformation(
                    context.getString(R.string.exp_info_compose)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_plural)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_mvvm_recommandation)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_collab)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_canvas)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_ddui)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_flavor)
                )
            )
        ),
        Experience(
            name = context.getString(R.string.exp_spending_flutter_name),
            logo = R.drawable.ic_spending,
            expDates = Dates(begin = Date(1728075200000), end = null),
            professional = false,
            informations = listOf(
                ExperienceInformation(
                    context.getString(R.string.exp_info_spending_flutter)
                ),
            )
        ),
        Experience(
            name = context.getString(R.string.exp_spending_name),
            logo = R.drawable.ic_spending,
            expDates = Dates(begin = Date(1664575200000), end = Date(1699575200000)),
            professional = false,
            informations = listOf(
                ExperienceInformation(
                    context.getString(R.string.exp_info_compose)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_room)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_data_store)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_pagination)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_modification_standart)
                )
            )
        ),
        Experience(
            name = context.getString(R.string.exp_fdc_name),
            logo = R.drawable.ic_exp_fresque,
            expDates = Dates(begin = Date(1593554400000), end = Date(1641596400000)),
            professional = false,
            informations = listOf(
                ExperienceInformation(
                    context.getString(R.string.exp_info_android_kotlin)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_fdc_feature)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_unit_test)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_dependency_injection)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_mvvm)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_library_search)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_jetpack)
                )
            )
        ),
        Experience(
            name = context.getString(R.string.exp_sh_name),
            employer = context.getString(R.string.exp_sh_employer),
            logo = R.drawable.ic_exp_sh,
            expDates = Dates(begin = Date(1572562800000), end = Date(1590962400000)),
            professional = true,
            informations = listOf(
                ExperienceInformation(
                    context.getString(R.string.exp_info_sh_update)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_spec)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_commentary)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_sh_environement)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_sh_new)
                )
            )
        ),
        Experience(
            name = context.getString(R.string.exp_natixis_name),
            employer = context.getString(R.string.exp_natixis_employer),
            logo = R.drawable.ic_exp_natixis,
            expDates = Dates(begin = Date(1472680800000), end = Date(1559340000000)),
            professional = true,
            informations = listOf(
                ExperienceInformation(
                    context.getString(R.string.exp_info_nat_autonomy)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_nat_analysis)
                ),
                ExperienceInformation(
                    context.getString(R.string.exp_info_nat_test)
                )
            )
        )
    )
}