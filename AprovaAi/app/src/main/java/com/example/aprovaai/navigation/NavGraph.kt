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
import com.example.aprovaai.models.EstudosConteudos
import com.example.aprovaai.R
import com.example.aprovaai.ui.screens.ConteudosScreen
import com.example.aprovaai.ui.screens.DisciplinasScreen
import com.example.aprovaai.ui.screens.FavoritosScreen
import com.example.aprovaai.ui.screens.MusicasScreen



sealed class BottomBarScreen(val route: String, val icon: @Composable () -> Unit, val label: String) {
    object Home : BottomBarScreen(
        route = "home",
        icon = { androidx.compose.material3.Icon(Icons.Default.Home, contentDescription = "Home") },
        label = "Home"
    )

    object Revisar : BottomBarScreen(
        route = "favoritos",
        icon = { androidx.compose.material3.Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
        label = "Favoritos"
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
                FavoritosScreen(
                    onDisciplinaSelected = { disciplina ->
                        navController.navigate("details/${disciplina.name}")
                    },
                    onFavoriteToggle = { disciplina ->
                            disciplina.isFavorite = !disciplina.isFavorite
                    }
                )
            }

//            MÚSICA
//            composable(BottomBarScreen.Musicas.route) {
//                MusicasScreen(
//                    disciplinas = Disciplinas.values().toList(),
//                    onSettingsClick = onSettingsClick,
//                    onHelpClick = onHelpClick
//                )
//            }

//            composable("disciplinas") {
//                val disciplinas = listOf(
//                    Disciplina(
//                        name = "Português",
//                        imageDisc = R.drawable.portugues,
//                        conteudos = listOf(
//                            EstudosConteudos(name = "Gramática"),
//                            EstudosConteudos(name = "Interpretação de Texto")
//                        )
//                    ),
//                    Disciplina(
//                        name = "Matemática",
//                        imageDisc = R.drawable.matematica,
//                        conteudos = listOf(
//                            EstudosConteudos(name = "Álgebra"),
//                            EstudosConteudos(name = "Geometria")
//                        )
//                    )
//                )
//
//                DisciplinasScreen(
//                    disciplinas = disciplinas,
//                    onDisciplinaSelected = { disciplina ->
//                        navController.navigate("conteudos/${disciplina.name}")
//                    }
//                )
//            }
//
//            // Tela de Conteúdos
//            composable(
//                route = "conteudos/{disciplinaName}",
//                arguments = listOf(navArgument("disciplinaName") { type = NavType.StringType })
//            ) { backStackEntry ->
//                val disciplinaName = backStackEntry.arguments?.getString("disciplinaName") ?: ""
//                val disciplina = disciplinas.find { it.name == disciplinaName }
//                disciplina?.let {
//                    ConteudosListScreen(
//                        conteudos = it.conteudos,
//                        onConteudoSelected = { conteudo ->
//                            navController.navigate("conteudoScreen/${conteudo.name}")
//                        }
//                    )
//                }
//            }
//
//            // Tela de Detalhes do Conteúdo
//            composable(
//                route = "conteudoScreen/{conteudoName}",
//                arguments = listOf(navArgument("conteudoName") { type = NavType.StringType })
//            ) { backStackEntry ->
//                val conteudoName = backStackEntry.arguments?.getString("conteudoName") ?: ""
//                ConteudosScreen(
//                    conteudos = EstudosConteudos(name = conteudoName),
//                    disciplina = Disciplina(name = ""),
//                    onRevisarToggle = {}
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