package com.adrienmandroid.composerandom

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.adrienmandroid.composecv.data.BottomNavGraph
import com.adrienmandroid.composecv.data.BottomNavGraphHost


//The screen + the bar at the bottom, under it.
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navGraphArray = BottomNavGraph.array

    Scaffold(
        bottomBar = { BottomBar(elementArray = navGraphArray, navController = navController) }
    ) {
        BottomNavGraphHost(navController = navController)
    }

}