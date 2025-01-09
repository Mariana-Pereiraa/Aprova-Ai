package com.example.aprovaai.ui.screens

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aprovaai.models.musicas

//tela de músicas
@Composable
fun MusicasScreen(context: Context) {

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp) // Padding para a coluna
    ) {
        Text(
            text = "Musicas",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(musicas.size) { index ->
                val musica = musicas[index]
                ListItem(
                    headlineContent = { Text(text = musica.nome) },
                    trailingContent = {
                        Button(onClick = { playSound(context, musica.soundRes) }) {
                            Text("Reproduzir")
                        }
                    },
                    modifier = Modifier.padding(vertical = 8.dp) // Espaçamento entre itens
                )
            }
        }
    }
}


fun playSound(context: Context, soundRes: Int) {
    try {
        val mediaPlayer = MediaPlayer.create(context, soundRes)
        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener {
            it.release()
        }
    } catch (e: Exception) {
        println("Erro ao inicializar o MediaPlayer: ${e.message}")
    }
}

@Preview
@Composable
fun MusicasScreenPreview() {
    // Simulando a navegação para o preview
    MusicasScreen(context = LocalContext.current)
}