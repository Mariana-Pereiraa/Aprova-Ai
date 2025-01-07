package com.example.aprovaai.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aprovaai.models.Disciplina
import com.example.aprovaai.ui.components.DisciplinaListItem


@Composable
fun DisciplinasScreen(
    disciplinas: List<Disciplina>,
    onDisciplinaSelected: (Disciplina) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Disciplinas",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(disciplinas) { disciplina ->
                DisciplinaListItem(
                    disciplina = disciplina,
                    onDisciplinaSelected = { onDisciplinaSelected(disciplina) },
                    onFavoriteToggle = { /* Adicionar funcionalidade de revisão se necessário */ }
                )
            }
        }
    }
}

//@Preview
//@Composable
//private fun DisciplinasScreenPrev() {
//    DisciplinasScreen(
//        disciplinas = listOf(
//            Disciplina(
//                name = "Matemática",
//                conteudos = listOf(
//                    ("Álgebra"),
//                    Disciplina.Conteudo("Geometria"),
//                    Disciplina.Conteudo("Cálculo")
//                )
//            ),
//            Disciplina(
//                name = "Português",
//                conteudos = listOf(
//                    Disciplina.Conteudo("Gramática"),
//                    Disciplina.Conteudo("Literatura")
//                )
//            )
//        ),
//        onDisciplinaSelected = { }
//    ) { }
//}
