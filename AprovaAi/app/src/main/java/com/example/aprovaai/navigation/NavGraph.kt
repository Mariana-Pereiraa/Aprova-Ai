package com.example.aprovaai.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.aprovaai.models.disciplinasList
import com.example.aprovaai.ui.components.BottomNavigationBar
import com.example.aprovaai.ui.components.TopAppBarWithMenu
import com.example.aprovaai.ui.screens.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aprovaai.data.PreferencesManager
import com.example.aprovaai.models.Disciplina
import com.example.aprovaai.ui.viewmodel.ThemeViewModel
import kotlinx.coroutines.launch

sealed class BottomBarScreen(val route: String, val icon: @Composable () -> Unit, val label: String) {
    object Home : BottomBarScreen(
        route = "home",
        icon = { androidx.compose.material3.Icon(Icons.Default.Home, contentDescription = "Home") },
        label = "Home"
    )

    object Favoritos : BottomBarScreen(
        route = "favoritos",
        icon = { androidx.compose.material3.Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
        label = "Favoritos"
    )

    object Musicas : BottomBarScreen(
        route = "musicas",
        icon = { androidx.compose.material3.Icon(Icons.Default.MusicNote, contentDescription = "Músicas") },
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
    val themeViewModel: ThemeViewModel = viewModel()
    val context = LocalContext.current
    val isNotificationsEnabled by PreferencesManager.notificationsEnabledFlow(context).collectAsStateWithLifecycle(initialValue = false)
    val isAnimationsEnabled = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    val favoriteDisciplinas = remember { mutableStateListOf<Disciplina>() }


    Scaffold(
        topBar = {
            TopAppBarWithMenu(
                onSettingsClick = {
                    navController.navigate("settings"){
                        popUpTo("home") { inclusive = true }
                    }
                },
                onHelpClick = {
                    navController.navigate("help"){
                        popUpTo("home") { inclusive = true}
                    }
                },
                onLogoutClick = {}
            )
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomBarScreen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            // Rota para a Home
            composable(BottomBarScreen.Home.route) {
                HomeScreen(
                    onDisciplinaSelected = { disciplina ->
                        navController.navigate("conteudos/${disciplina.name}")
                    },
                    onSettingsClick = {
                        navController.navigate("settings")
                    },
                    onHelpClick = onHelpClick
                )
            }

            // Rota para Conteúdos de uma Disciplina
            composable(
                route = "conteudos/{disciplinaName}",
                arguments = listOf(navArgument("disciplinaName") { type = NavType.StringType })
            ) { backStackEntry ->
                val disciplinaName = backStackEntry.arguments?.getString("disciplinaName") ?: ""
                val disciplina = disciplinasList.find { it.name == disciplinaName }

                disciplina?.let {
                    ConteudosScreen(
                        conteudos = it.conteudos,
                        onConteudoSelected = { conteudo ->
                            navController.navigate("detailsConteudo/${conteudo.name}")
                        }
                    )
                }

            }
            // Rota para Favoritos
            composable(BottomBarScreen.Favoritos.route) {
                FavoritosScreen(
                    onDisciplinaSelected = { disciplina ->
                        navController.navigate("details/${disciplina.name}")
                    },
                    onFavoriteToggle = { disciplina ->
                        disciplina.isFavorite = !disciplina.isFavorite
                    }
                )
            }

            // Rota para Detalhes de um Conteúdo
            composable(
                route = "detailsConteudo/{conteudoName}",
                arguments = listOf(navArgument("conteudoName") { type = NavType.StringType })
            ) { backStackEntry ->
                val conteudoName = backStackEntry.arguments?.getString("conteudoName") ?: ""
                val conteudo = disciplinasList.flatMap { it.conteudos }.find { it.name == conteudoName }
                val disciplina = disciplinasList.find { it.conteudos.any { conteudo -> conteudo.name == conteudoName } }

                if (conteudo != null && disciplina != null) {
                    DetailsConteudosScreen(
                        conteudos = conteudo,
                        onConteudoSelected = {},
                        disciplina = disciplina,
                        navController = navController,
                        context = LocalContext.current,
                        isNotificationsEnabled = isNotificationsEnabled
                    )
                }
            }

            // Rota para as músicas
            composable(BottomBarScreen.Musicas.route) {
                MusicasScreen(context = LocalContext.current)
            }

            // Rota para as configurações
            composable(route = "settings") {
                val isDarkModeEnabled by themeViewModel.isDarkMode.collectAsState()

                SettingsScreen(
                    themeViewModel = themeViewModel,
                    isNotificationsEnabled = isNotificationsEnabled,
                    onNotificationsToggle = { enabled ->
                        coroutineScope.launch {
                            PreferencesManager.setNotificationsEnabled(context, enabled)
                        }
                    },
                    isAnimationsEnabled = isAnimationsEnabled.value,
                    onAnimationsToggle = {
                        isAnimationsEnabled.value = !isAnimationsEnabled.value
                    }
                )
            }

            // Rota para a ajuda
            composable(route = "help") {
                HelpScreen(context = LocalContext.current,
                    navController = navController
                )
            }
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