package com.adrienmandroid.composecv.data

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adrienmandroid.composecv.ui.fragments.ExperienceFragment
import com.adrienmandroid.composecv.ui.fragments.SkillFragment
import com.adrienmandroid.composecv.ui.fragments.WelcomeFragment

//Navigation graph informations.
object BottomNavGraph {

    val WelcomeBottomNav = BottomNavElement("welcome", null, Icons.Default.Home)
    val ExpBottomNav = BottomNavElement("experience", "EXP.", Icons.Default.Home)
    val SkillBottomNav = BottomNavElement("skill", "Skill", Icons.Default.Home)

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
            SkillFragment(SkillData.skills)
        }
    }
}