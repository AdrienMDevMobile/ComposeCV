package com.adrienmandroid.composecv.ui.nav

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.adrienmandroid.composecv.data.BottomNavElement
import com.adrienmandroid.composecv.data.dataSource.BottomNavGraph
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme
import com.adrienmandroid.composerandom.Nav.BottomBarItemDesign

//The design of the bottomBar
@Composable
fun BottomBarDesign(
    vararg elements: BottomNavElement,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        Row() {
            for (element in elements) {
                BottomBarItemDesign(element, currentDestination, navController)
            }
        }


    }

}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "nuit",
    widthDp = 300,
    heightDp = 200
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    name = "jour",
    widthDp = 200,
    heightDp = 200
)
@Composable
fun BottomBarPreview() {
    val navController = rememberNavController()
    ComposeCVTheme {

        BottomBarDesign(
            *BottomNavGraph.array, currentDestination = null, navController = navController
        )
        //MainElement("Formation", R.drawable.ic_android_black_24dp),
        //MainElement("Intérêts", R.drawable.ic_android_black_24dp))
    }

}