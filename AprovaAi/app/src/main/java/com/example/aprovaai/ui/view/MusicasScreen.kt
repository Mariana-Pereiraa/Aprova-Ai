package com.example.aprovaai.ui.view

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aprovaai.models.musicas

// Tela de músicas
@Composable
fun MusicasScreen(context: Context) {
    // Estado para controlar qual música está tocando
    var playingIndex by remember { mutableStateOf<Int?>(null) }
    val mediaPlayer = remember { mutableStateOf<MediaPlayer?>(null) }  // Estado do MediaPlayer

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp) // Padding para a coluna
    ) {
        Text(
            text = "Músicas",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(musicas.size) { index ->
                val musica = musicas[index]
                val isPlaying = playingIndex == index // Verifica se a música está tocando

                ListItem(
                    headlineContent = { Text(text = musica.nome) },
                    trailingContent = {
                        Button(onClick = {
                            if (isPlaying) {
                                // Pausar a música
                                pauseMusic(mediaPlayer.value)
                                playingIndex = null // Atualiza o estado para pausado
                            } else {
                                // Reproduzir a música
                                playSound(context, musica.soundRes, mediaPlayer)
                                playingIndex = index // Atualiza o estado para tocando
                            }
                        },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isPlaying) MaterialTheme.colorScheme.onSurface
                                else MaterialTheme.colorScheme.primary
                            )
                        ) {
                            Text(if (isPlaying) "Pausar" else "Reproduzir")
                        }
                    },
                    modifier = Modifier.padding(vertical = 8.dp) // Espaçamento entre itens
                )
            }
        }
    }
}

// Função para reproduzir o som
fun playSound(context: Context, soundRes: Int, mediaPlayerState: MutableState<MediaPlayer?>) {
    try {
        // Libera o player anterior se existir
        mediaPlayerState.value?.release()
        val player = MediaPlayer.create(context, soundRes)
        mediaPlayerState.value = player
        player.start()
        player.setOnCompletionListener {
            it.release() // Libera o player quando a música terminar
            mediaPlayerState.value = null // Zera o player
        }
    } catch (e: Exception) {
        println("Erro ao inicializar o MediaPlayer: ${e.message}")
    }
}

// Função para pausar o som
fun pauseMusic(mediaPlayer: MediaPlayer?) {
    mediaPlayer?.pause()
}

@Preview
@Composable
fun MusicasScreenPreview() {
    // Simulando a navegação para o preview
    MusicasScreen(context = LocalContext.current)
}
