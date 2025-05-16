package com.adrienmandroid.composecv.ui.nav

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.adrienmandroid.composecv.data.BottomNavElement

//Calls the design of the bottom bar and handles the navigation.
@Composable
fun BottomBar(elementArray: Array<BottomNavElement>, navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        BottomBarDesign(
            *elementArray,
            currentDestination = currentDestination,
            navController = navController
        )
    }
}