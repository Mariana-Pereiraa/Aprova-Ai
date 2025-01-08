package com.example.aprovaai.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.aprovaai.models.EstudosConteudos
import com.example.aprovaai.models.Dificuldade
import com.example.aprovaai.models.Disciplina
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsConteudosScreen(conteudos: EstudosConteudos,
                           onConteudoSelected: (EstudosConteudos) -> Unit,
                            disciplina: Disciplina,
                            context: Context,
                           navController: NavController) {
    // Estados para gerenciar as interações
    var dataEstudo by remember { mutableStateOf("") }
    var dificuldadeSelecionada by remember { mutableStateOf(conteudos.dificuldade.name) }
    val opcoesDificuldade = Dificuldade.values().map { it.name }
    var checkEstudo by remember { mutableStateOf(conteudos.checkEstudo) }
    var resolucao by remember { mutableStateOf(conteudos.resolucao) }
    var revisar by remember { mutableStateOf(conteudos.isRevisar) }
    var anotacoes by remember { mutableStateOf(conteudos.anotacoes) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        // Cabeçalho da tela
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center // Centraliza o conteúdo
        ) {
            Text(
                text = disciplina.name, // Esse texto pode ser dinâmico conforme a disciplina
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))

        // Exibindo o conteúdo do item
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = conteudos.name, // Também pode ser alterado conforme a seleção
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        // Data de Estudo
        OutlinedTextField(
            value = dataEstudo,
            onValueChange = { dataEstudo = it },
            label = { Text("Data de Estudo") },
            placeholder = { Text("dd/mm/yyyy") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Dificuldade
        Text(
            text = "Dificuldade:",
            style = MaterialTheme.typography.bodyLarge
        )
        DropdownDificuldade(
            dificuldadeSelecionada,
            opcoesDificuldade,
            onDificuldadeSelecionada = { dificuldadeSelecionada = it }
        )

        // Checkboxes
        CheckboxComLabel(
            label = "Estudei todo o conteúdo?",
            checked = checkEstudo,
            onCheckedChange = { checkEstudo = it }
        )
        CheckboxComLabel(
            label = "Resolvi questões?",
            checked = resolucao,
            onCheckedChange = { resolucao = it }
        )

        CheckboxComLabel(
            label = "Preciso revisar?",
            checked = revisar,
            onCheckedChange = { revisar = it }
        )

        // Anotações
        Text(
            text = "Anotações:",
            style = MaterialTheme.typography.bodyLarge
        )
        OutlinedTextField(
            value = anotacoes,
            onValueChange = { anotacoes = it },
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
                Toast.makeText(context, "Conteúdo salvo com sucesso!", Toast.LENGTH_SHORT).show()

                navController.popBackStack()
            }) {
                Text("Salvar")
            }
        }
    }
}

@Composable
fun DropdownDificuldade(
    dificuldadeSelecionada: String,
    opcoes: List<String>,
    onDificuldadeSelecionada: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedButton(onClick = { expanded = !expanded }) {
            Text(dificuldadeSelecionada)
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            opcoes.forEach { dificuldade ->
                DropdownMenuItem(
                    text = { Text(dificuldade) },
                    onClick = {
                        onDificuldadeSelecionada(dificuldade)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun CheckboxComLabel(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
