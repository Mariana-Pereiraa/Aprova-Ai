package com.example.aprovaai.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Reviews
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.aprovaai.models.Disciplina
import com.example.aprovaai.ui.components.BottomNavigationBar
//import com.example.aprovaai.ui.screens.DetailsScreen
//import com.example.aprovaai.ui.screens.FavoritesScreen
import com.example.aprovaai.ui.screens.HomeScreen
import androidx.navigation.compose.composable
import com.example.aprovaai.ui.screens.RevisarScreen


sealed class BottomBarScreen(val route: String, val icon: @Composable () -> Unit, val label: String) {
    object Home : BottomBarScreen(
        route = "home",
        icon = { androidx.compose.material3.Icon(Icons.Default.Home, contentDescription = "Home") },
        label = "Home"
    )

    object Revisar : BottomBarScreen(
        route = "revisar",
        icon = { androidx.compose.material3.Icon(Icons.Default.Reviews, contentDescription = "Favorites") },
        label = "Revisar"
    )

    object Musicas : BottomBarScreen(
        route = "musicas",
        icon = { androidx.compose.material3.Icon(Icons.Default.MusicNote, contentDescription = "Favorites") },
        label = "Músicas"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavGraph(
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit
) {
    val navController = rememberNavController()

    Scaffold (
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
        innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            //Home
            composable(BottomBarScreen.Home.route) {
                HomeScreen(
                    onDisciplinaSelected = { disciplina ->
                        navController.navigate("details/${disciplina.name}")
                    },
                    onSettingsClick = onSettingsClick,
                    onHelpClick = onHelpClick
                )
            }
            composable(BottomBarScreen.Revisar.route) {
                RevisarScreen(
                    onDisciplinaSelected = { disciplina ->
                        navController.navigate("details/${disciplina.name}")
                    },
                    onRevisarToggle = { disciplina ->
                        disciplina.conteudos.isRevisar = !disciplina.conteudos.isRevisar

                    }
                )
            }
//            MÚSICA
//            composable(BottomBarScreen.Musicas.route) {
//                ConteudosScreen(
//                    disciplinas = Disciplinas.values().toList(),
//                    onSettingsClick = onSettingsClick,
//                    onHelpClick = onHelpClick
//                )
//            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun NavGraphPreview() {
    NavGraph(
        onSettingsClick = {},
        onHelpClick = {}
    )
}