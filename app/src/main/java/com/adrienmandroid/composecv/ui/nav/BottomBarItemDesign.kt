package com.adrienmandroid.composecv.ui.nav

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.adrienmandroid.composecv.data.model.BottomNavElement
import com.adrienmandroid.composecv.data.dataSource.BottomNavGraph
import com.adrienmandroid.composecv.core.ui.theme.ComposeCVTheme

//The design of one item in the nav bar
@Composable
fun RowScope.BottomBarItemDesign(
    element: BottomNavElement,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val isSelected =
        currentDestination?.hierarchy?.any { it.route == element.route } == true

    BottomNavigationItem(
        //label = if(element.name != null){ { Text(text = element.name) }} else null,
        icon = {
            Icon(
                painter = painterResource(
                    id = if (isSelected) {
                        element.imageSelected
                    } else {
                        element.imageUnSelected
                    },
                ),
                contentDescription = element.name,
                modifier = Modifier
                    .size(30.dp)
                    .defaultMinSize(30.dp)
            )
        },
        selected = isSelected,
        onClick = { navController.navigate(element.route) }
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
    ComposeCVTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            Row {
                BottomBarItemDesign(BottomNavGraph.array[0], null, navController)
            }
        }
    }

}