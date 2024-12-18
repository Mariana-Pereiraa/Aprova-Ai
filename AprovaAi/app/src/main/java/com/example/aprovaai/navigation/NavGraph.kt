package com.example.aprovaai.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.aprovaai.models.Disciplinas
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.aprovaai.ui.screens.ConteudosScreen
import com.example.aprovaai.ui.screens.HomeScreen


@Composable
fun NavGraph(navController: NavHostController) {
    val disciplinas = Disciplinas()

    NavHost(navController = navController, startDestination = "conteudo_screen/Português"){
        composable("home_screen"){
            HomeScreen(navController)
        }
        composable("conteudo_screen/{disciplina}")
        {backStackEntry ->
            val disciplina = backStackEntry.arguments?.getString("disciplina")?:"Português"
            val conteudos = disciplinas.getConteudosByDsciplinas(disciplina)
            ConteudosScreen(conteudos = conteudos)
        }
    }
}