package com.adrienmandroid.composecv.data.dataSource

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adrienmandroid.composecv.R
import com.adrienmandroid.composecv.data.BottomNavElement
import com.adrienmandroid.composecv.data.dataSource.impl.SkillDataImpl
import com.adrienmandroid.composecv.ui.fragments.ExperienceFragment
import com.adrienmandroid.composecv.ui.fragments.SkillFragment
import com.adrienmandroid.composecv.ui.fragments.WelcomeFragment

//Navigation graph informations.
object BottomNavGraph {

    val WelcomeBottomNav = BottomNavElement("welcome", null, R.drawable.home)
    val ExpBottomNav = BottomNavElement("experience", "EXP.",R.drawable.experience)
    val SkillBottomNav = BottomNavElement("skill", "Skill", R.drawable.skill)

    val array = arrayOf(WelcomeBottomNav, ExpBottomNav, SkillBottomNav)

}

//Will host the informations from the Nav graph.
@ExperimentalMaterialApi
@Composable
fun BottomNavGraphHost(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = BottomNavGraph.array[0].route)
    {
        composable(route=BottomNavGraph.WelcomeBottomNav.route){
            WelcomeFragment()
        }
        composable(route = BottomNavGraph.ExpBottomNav.route) {
            ExperienceFragment()
        }
        composable(route = BottomNavGraph.SkillBottomNav.route) {
            SkillFragment(SkillDataImpl().getSkills())
        }
    }
}