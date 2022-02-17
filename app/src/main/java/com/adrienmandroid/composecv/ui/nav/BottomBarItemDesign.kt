package com.adrienmandroid.composerandom.Nav

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.adrienmandroid.composecv.data.BottomNavElement
import com.adrienmandroid.composecv.data.BottomNavGraph
import com.adrienmandroid.composecv.ui.theme.ComposeCVTheme

//The design of one item in the nav bar
@Composable
fun RowScope.BottomBarItemDesign(
    element: BottomNavElement,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(label = { Text(text = element.name) },
        icon = {
            Icon(
                imageVector = element.image,
                contentDescription = element.name
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == element.route } == true,
        onClick = { navController.navigate(element.route) },
        modifier = Modifier.border(1.dp, MaterialTheme.colors.onBackground)
    )
}


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "nuit",
    widthDp = 50,
    heightDp = 50
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = true,
    name = "jour",
    widthDp = 50,
    heightDp = 50
)
@Composable
fun BottomBarItemPreview() {
    val navController = rememberNavController()
    ComposeCVTheme() {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            Row {
                BottomBarItemDesign(BottomNavGraph.array[0], null, navController)
            }
        }
    }

}