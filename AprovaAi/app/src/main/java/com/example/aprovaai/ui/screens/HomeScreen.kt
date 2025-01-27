package com.example.aprovaai.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aprovaai.models.Disciplina
import com.example.aprovaai.models.disciplinasList
import com.example.aprovaai.ui.components.DisciplinaListItem
import com.example.aprovaai.ui.theme.BlueBase
import com.example.aprovaai.ui.theme.GrayDark
import com.example.aprovaai.ui.theme.GrayLight
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onDisciplinaSelected: (Disciplina) -> Unit,
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var searchQuery by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val recentsSearches = viewModel.recentsSearches

    var filtroDisciplinas by remember { mutableStateOf(disciplinasList) }

    // Simulando carregamento ao digitar
    LaunchedEffect(searchQuery) {
        isLoading = true
        delay(500)
        filtroDisciplinas = disciplinasList.filter { it.name.contains(searchQuery, ignoreCase = true) }
        isLoading = false
    }

    Column(modifier = Modifier.padding(8.dp)) {
        // Campo de pesquisa
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Pesquisar") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Pesquisar"
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = GrayLight,
                disabledIndicatorColor = BlueBase,
                focusedIndicatorColor = BlueBase,
                focusedLabelColor = GrayDark,
                focusedTextColor = GrayDark,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        // Exibindo buscas recentes
        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(recentsSearches, key = { it.id }) { disciplina ->
                Button(onClick = { onDisciplinaSelected(disciplina) }) {
                    Text(disciplina.name)
                }
            }
        }

        // Exibir ProgressBar enquanto a busca está carregando
        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            // Exibir lista de disciplinas filtradas
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                items(filtroDisciplinas) { disciplina ->
                    DisciplinaListItem(
                        disciplina = disciplina,
                        onDisciplinaSelected = { selectedDisciplina ->
                            if (!recentsSearches.contains(selectedDisciplina)) {
                                recentsSearches.add(0, selectedDisciplina)
                            }
                            onDisciplinaSelected(selectedDisciplina)
                        },
                        onFavoriteToggle = { favoriteDisciplina ->
                            favoriteDisciplina.isFavorite = !favoriteDisciplina.isFavorite
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onDisciplinaSelected = {},
        onSettingsClick = {},
        onHelpClick = {}
    )
}
