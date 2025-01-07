package com.example.aprovaai.ui.components

import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.aprovaai.navigation.BottomBarScreen
import com.example.aprovaai.ui.theme.BlueBase
import com.example.aprovaai.ui.theme.BlueDark
import com.example.aprovaai.ui.theme.BlueLight

@Composable
fun BottomNavigationBar(navController: NavController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Revisar,
        BottomBarScreen.Musicas
    )

    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    NavigationBar {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = screen.icon,
                label = { Text(screen.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = BlueBase,
                    unselectedIconColor = colorScheme.onSurfaceVariant
                )
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavigationBarPreview() {
    BottomNavigationBar(
        navController = NavController(LocalContext.current)
    )
}