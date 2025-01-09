package com.adrienmandroid.composecv.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.adrienmandroid.composecv.data.dataSource.BottomNavGraph
import com.adrienmandroid.composecv.data.dataSource.BottomNavGraphHost
import com.adrienmandroid.composecv.ui.nav.BottomBar


//The screen + the bar at the bottom, under it.
@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navGraphArray = BottomNavGraph.array

    Scaffold(
        bottomBar = { BottomBar(elementArray = navGraphArray, navController = navController) }
    ) { innerPadding ->
        // Padding Value is the only parameter of the parameter component
        Box(modifier = Modifier.padding(innerPadding)) {
            BottomNavGraphHost(navController = navController)
        }
    }
}