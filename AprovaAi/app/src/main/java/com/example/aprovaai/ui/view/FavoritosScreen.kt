package com.example.aprovaai.ui.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aprovaai.models.Disciplina
import com.example.aprovaai.models.disciplinasList
import com.example.aprovaai.ui.components.DisciplinaListItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

@ExperimentalMaterial3Api
@Composable
fun FavoritosScreen(
    onDisciplinaSelected: (Disciplina) -> Unit,
    onFavoriteToggle: (Disciplina) -> Unit
) {
    val favoriteDisciplinas = remember { mutableStateListOf<Disciplina>() }
    val coroutineScope = rememberCoroutineScope()

    // Atualiza os favoritos sempre que a tela for recomposada
    LaunchedEffect(disciplinasList) {
        favoriteDisciplinas.clear()
        favoriteDisciplinas.addAll(disciplinasList.filter { it.isFavorite })
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Favoritos",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                },
                actions = {
                    IconButton(
                        onClick = {
                            coroutineScope.launch {
                                // Limpar todos os favoritos com animação
                                val toRemove = favoriteDisciplinas.toList()
                                toRemove.forEach { disciplina ->
                                    // Remover item um por um com animação
                                    favoriteDisciplinas.remove(disciplina)
                                    delay(600)  // Duração da animação para cada item removido
                                }
                                disciplinasList.forEach { it.isFavorite = false }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = androidx.compose.material.icons.Icons.Default.Delete,
                            contentDescription = "Limpar Favoritos",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    ) { innerPadding ->
        if (favoriteDisciplinas.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Você não tem disciplinas favoritas.",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 8.dp)
            ) {
                items(favoriteDisciplinas, key = { it.id }) { disciplina ->
                    var isRemoved by remember { mutableStateOf(false) }

                    // Animação de transição: subindo e sumindo
                    val translationY by animateFloatAsState(
                        targetValue = if (isRemoved) -100f else 0f,  // Movendo para cima
                        animationSpec = tween(durationMillis = 1000)  // Mais lenta para o efeito suave
                    )
                    val alpha by animateFloatAsState(
                        targetValue = if (isRemoved) 0f else 1f,  // Desaparecendo
                        animationSpec = tween(durationMillis = 1000)  // Mais lenta para o efeito suave
                    )

                    Box(
                        modifier = Modifier
                            .offset { IntOffset(0, translationY.roundToInt()) }  // Movendo o item para cima
                            .alpha(alpha)  // Diminuindo a opacidade para 0
                    ) {
                        DisciplinaListItem(
                            disciplina = disciplina,
                            onDisciplinaSelected = { onDisciplinaSelected(it) },
                            onFavoriteToggle = {
                                disciplina.isFavorite = !disciplina.isFavorite
                                if (!disciplina.isFavorite) {
                                    coroutineScope.launch {
                                        isRemoved = true
                                        delay(1000) // Espera pela animação de remoção
                                        favoriteDisciplinas.remove(disciplina) // Remove o item após animação
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}







@ExperimentalMaterial3Api
@Preview
@Composable
private fun RevisarScreenPrev() {
    FavoritosScreen(
        onDisciplinaSelected = {},
        onFavoriteToggle = {}
    )
}
