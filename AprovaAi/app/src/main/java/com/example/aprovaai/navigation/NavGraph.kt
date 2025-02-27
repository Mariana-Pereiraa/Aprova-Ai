package com.example.aprovaai.navigation

import DetailsConteudosScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.MoreVert // Adicionei o ícone de três pontinhos
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aprovaai.models.disciplinasList
import com.example.aprovaai.ui.components.BottomNavigationBar
import com.example.aprovaai.ui.components.TopAppBarWithMenu
import com.example.aprovaai.ui.view.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.aprovaai.data.PreferencesManager
import com.example.aprovaai.ui.viewmodel.ThemeViewModel
import kotlinx.coroutines.launch
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import androidx.compose.animation.*
import com.example.aprovaai.ui.viewmodel.AuthViewModel
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.aprovaai.ui.viewmodel.EstudosConteudosViewModel

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

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun NavGraph(
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit,
    viewModel: AuthViewModel,
    estudosConteudosViewModel: EstudosConteudosViewModel
) {
    val navController = rememberNavController()
    val themeViewModel: ThemeViewModel = viewModel()
    val context = LocalContext.current
    val isNotificationsEnabled by PreferencesManager.notificationsEnabledFlow(context).collectAsStateWithLifecycle(initialValue = false)
    val isAnimationsEnabled = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route


    Scaffold(
        topBar = {
            //mudar aqui pra não aparecer o top
            if (currentRoute != "login") {
                TopAppBarWithMenu(
                    onSettingsClick = {
                        navController.navigate("settings") {
                            popUpTo("home") { inclusive = true }
                        }
                    },
                    onHelpClick = {
                        navController.navigate("help") {
                            popUpTo("home") { inclusive = true }
                        }
                    },
                    onLogoutClick = {
                        viewModel.logout()
                        navController.navigate("login") {
                            popUpTo("home") { inclusive = true }
                        }
                    }
                )
            }
        },
        //mudar aqui pra não aparecer o bottom
        bottomBar = {
            if (currentRoute != "login") {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = "login", // Defina a tela de login como a primeira tela
            modifier = Modifier.padding(innerPadding),
            enterTransition = { slideInHorizontally(initialOffsetX = { it }) + fadeIn() },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }) + fadeOut() },
            popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }) + fadeIn() },
            popExitTransition = { slideOutHorizontally(targetOffsetX = { it }) + fadeOut() }
        ) {
            composable("login") {
                LoginScreen(viewModel = viewModel, navController = navController)
            }

            composable(BottomBarScreen.Home.route) {
                HomeScreen(
                    onDisciplinaSelected = { disciplina ->
                        navController.navigate("conteudos/${disciplina.name}") {
                            popUpTo("home") { inclusive = true }
                        }
                    },
                    onSettingsClick = { navController.navigate("settings") },
                    onHelpClick = onHelpClick
                )
            }

            // Rota para conteúdos
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
                            navController.navigate("detailsConteudo/${conteudo.name}") {
                                popUpTo("home") { inclusive = true }
                            }
                        }
                    )
                }
            }

            // Rota para favoritos
            composable(BottomBarScreen.Favoritos.route) {
                FavoritosScreen(
                    onDisciplinaSelected = { disciplina ->
                        navController.navigate("details/${disciplina.name}") {}
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
                        isNotificationsEnabled = isNotificationsEnabled,
                        viewModel = estudosConteudosViewModel
                    )
                }
            }

            composable(BottomBarScreen.Musicas.route) {
                MusicasScreen(context = LocalContext.current)
            }

            composable("settings") {
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

            // Rota para tela de ajuda
            composable("help") {
                HelpScreen(context = LocalContext.current, navController = navController)
            }

            composable("register") {
                RegisterScreen(viewModel = viewModel, navController = navController)
            }

            composable("forgotPassword") {
                ForgotPasswordScreen(viewModel = viewModel, navController = navController)
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWithMenu(
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) } // Controla a visibilidade do menu

    androidx.compose.material3.TopAppBar(
        title = { Text("AprovaAi") }, // Título da TopAppBar
        actions = {
            // Ícone de três pontinhos (menu)
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Mais opções"
                )
            }

            // Menu suspenso
            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {
                // Item de Configurações
                DropdownMenuItem(
                    text = { Text("Configurações") },
                    onClick = {
                        onSettingsClick()
                        showMenu = false
                    }
                )

                // Item de Ajuda
                DropdownMenuItem(
                    text = { Text("Ajuda") },
                    onClick = {
                        onHelpClick()
                        showMenu = false
                    }
                )

                // Item de Logout
                DropdownMenuItem(
                    text = { Text("Sair") },
                    onClick = {
                        onLogoutClick()
                        showMenu = false
                    }
                )
            }
        }
    )
}