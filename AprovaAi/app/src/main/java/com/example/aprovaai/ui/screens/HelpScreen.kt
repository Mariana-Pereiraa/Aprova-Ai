package com.example.aprovaai.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

//tela de ajuda que vai ser acionada no menu tres pontos
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpScreen(
    context: Context,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ajuda") },
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Quer garantir vaga no seu curso dos sonhos e não sabe o que estudar?",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Com o Aprova Aí, seu facilitador nos estudos para o ENEM, você descobre todos os conteúdos reincidentes nas provas!",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "Descubra o Passo a Passo de como usar o Aprova Aí 😉📖🖋️",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Sessão: Visualizar Conteúdos
            HelpSection(
                title = "Visualizar Conteúdos de Uma Disciplina Específica",
                steps = listOf(
                    "Clique na disciplina desejada;",
                    "Pronto, você conseguirá ver todos os conteúdos!"
                )
            )

            // Sessão: Visualizar Músicas
            HelpSection(
                title = "Visualizar Lista de Músicas e Escolher Uma Para Ouvir",
                steps = listOf(
                    "Clique em \"Músicas\";",
                    "Visualize todas as opções disponíveis;",
                    "Agora é só clicar em uma e desfrutar o som enquanto estuda!"
                )
            )

            // Sessão: Favoritar Disciplinas
            HelpSection(
                title = "Favoritar Disciplinas",
                steps = listOf(
                    "Ao visualizar uma disciplina, clique no coração presente ao lado dela;",
                    "Pronto, agora sua disciplina está favoritada e também presente em \"Favoritos\"."
                )
            )

            // Sessão: Adicionar Anotações
            HelpSection(
                title = "Adicionar Anotação em um Conteúdo Específico",
                steps = listOf(
                    "Clique na disciplina desejada;",
                    "Insira seu texto no campo \"Anotação\";",
                    "Clique em salvar;",
                    "Pronto, sua anotação está salva!"
                )
            )

            Text(
                text = "Dúvidas:",
                style = MaterialTheme.typography.bodyLarge
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Escreva aqui") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    Toast.makeText(context, "Dúvida enviada!", Toast.LENGTH_SHORT).show()

                    navController.popBackStack()
                }) {
                    Text("Enviar")
                }
            }
        }
    }
}

@Composable
fun HelpSection(title: String, steps: List<String>) {
    Text(
        text = title,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(vertical = 8.dp)
    )
    steps.forEachIndexed { index, step ->
        Text(
            text = "${index + 1}. $step",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 16.dp, bottom = 4.dp)
        )
    }
}

