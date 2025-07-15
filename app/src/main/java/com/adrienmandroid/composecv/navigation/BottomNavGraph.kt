package com.adrienmandroid.composecv.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.feature.experience.ui.ExperienceFragment
import com.adrienmandroid.composecv.feature.other.ui.OtherFragment
import com.adrienmandroid.composecv.feature.skills.ui.SkillFragment
import com.adrienmandroid.composecv.feature.welcome.ui.WelcomeFragment
import com.adrienmandroid.composecv.model.BottomNavElement

//Navigation graph informations.
object BottomNavGraph {

    val WelcomeBottomNav = BottomNavElement(
        "welcome", null,
        R.drawable.ic_tab_home,
        R.drawable.ic_tab_home_unselected
    )
    val ExpBottomNav = BottomNavElement(
        "experience", "EXP.",
        R.drawable.ic_tab_experience,
        R.drawable.ic_tab_experience_unselected
    )
    val SkillBottomNav = BottomNavElement(
        "skill", "Skill",
        R.drawable.ic_tab_skill,
        R.drawable.ic_tab_skill_unselected
    )
    val OtherBottomNav = BottomNavElement(
        "other", "other",
        R.drawable.ic_tab_other,
        R.drawable.ic_tab_other_unselected
    )

    val array = arrayOf(WelcomeBottomNav, ExpBottomNav, SkillBottomNav, OtherBottomNav)

}

//Will host the informations from the Nav graph.
@ExperimentalMaterialApi
@Composable
fun BottomNavGraphHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavGraph.array[0].route
    )
    {
        composable(route = BottomNavGraph.WelcomeBottomNav.route) {
            WelcomeFragment()
        }
        composable(route = BottomNavGraph.ExpBottomNav.route) {
            ExperienceFragment()
        }
        composable(route = BottomNavGraph.SkillBottomNav.route) {
            SkillFragment()
        }
        composable(route = BottomNavGraph.OtherBottomNav.route) {
            OtherFragment()
        }
    }
}