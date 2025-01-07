package com.example.aprovaai.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.aprovaai.models.Disciplina
import com.example.aprovaai.models.disciplinasList
import com.example.aprovaai.ui.components.DisciplinaListItem
import com.example.aprovaai.ui.components.TopAppBarWithMenu
import com.example.aprovaai.ui.theme.BlueBase
import com.example.aprovaai.ui.theme.GrayDark
import com.example.aprovaai.ui.theme.GrayLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onDisciplinaSelected: (Disciplina) -> Unit,
    onSettingsClick: () -> Unit,
    onHelpClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf("") }
    val filtroDisciplinas = remember(searchQuery){
        disciplinasList.filter { it.name.contains(searchQuery, ignoreCase = true) }
    }

    val recentsSearches = remember { mutableStateListOf<Disciplina>() }

    Scaffold (
        topBar = {
            TopAppBarWithMenu(
                onSettingsClick = onSettingsClick,
                onHelpClick = onHelpClick
            )
        }
    ){innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
        ){//pesquisa
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
                    focusedLabelColor = GrayDark
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)

            )

            //buscas recentes
            LazyRow (
                modifier = Modifier.padding(
                    vertical = 8.dp,
                    horizontal = 8.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                items(recentsSearches) { disciplina ->
                    Button(onClick = { onDisciplinaSelected(disciplina) }) {
                        Text(disciplina.name)
                    }
                }
            }

            //disciplinas filtradas

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 8.dp)
            )  {
                items(filtroDisciplinas) { disciplina ->
                    DisciplinaListItem(
                        disciplina = disciplina,
                        onDisciplinaSelected = { selectedDisciplina ->
                            if (!recentsSearches.contains(selectedDisciplina)) {
                                recentsSearches.add(0, selectedDisciplina)
                            }
                            onDisciplinaSelected(selectedDisciplina)
                        },
                        onRevisarToggle = { revisarDisciplina ->
                            revisarDisciplina.conteudos.isRevisar = !revisarDisciplina.conteudos.isRevisar
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