package com.example.aprovaai.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aprovaai.models.Disciplina
import com.example.aprovaai.models.disciplinasList
import com.example.aprovaai.ui.components.DisciplinaListItem
import java.nio.file.WatchEvent

@ExperimentalMaterial3Api
@Composable
fun RevisarScreen(
    onDisciplinaSelected: (Disciplina) -> Unit,
    onRevisarToggle: (Disciplina) -> Unit
) {
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Revisar",
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            )
        }
    ){  innerPadding ->
        val revisarDisciplinas = disciplinasList.filter { it.conteudos.isRevisar }

        if(revisarDisciplinas.isEmpty()) {
            // Exibe o texto padrão quando não há disciplinas para revisar
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Você não tem disciplinas para revisar.",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            // Exibe a lista de disciplinas para revisar
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 8.dp)
            ){
                items(revisarDisciplinas) { disciplina ->
                    DisciplinaListItem(
                        disciplina = disciplina,
                        onDisciplinaSelected = {onDisciplinaSelected(it)},
                        onRevisarToggle = {onRevisarToggle(it)}
                    )
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun RevisarScreenPrev() {
    RevisarScreen(
        onDisciplinaSelected = {},
        onRevisarToggle = {}
    )
}