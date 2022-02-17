package com.adrienmandroid.composecv.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.adrienmandroid.composecv.ui.fragments.ExperienceFragment
import com.adrienmandroid.composecv.ui.fragments.SkillFragment

//Navigation graph informations.
object BottomNavGraph {

    val Exp = BottomNavElement("experience", "EXP.", Icons.Default.Home)
    val Skill = BottomNavElement("skill", "Skill", Icons.Default.Home)

    val array = arrayOf(Exp, Skill)

}

//Will host the informations from the Nav graph.
@Composable
fun BottomNavGraphHost(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = BottomNavGraph.array[0].route)
    {
        composable(route = BottomNavGraph.Exp.route) {
            ExperienceFragment()
        }
        composable(route = BottomNavGraph.Skill.route) {
            SkillFragment()
        }
    }
}