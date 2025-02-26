package com.example.aprovaai.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aprovaai.models.EstudosConteudos
import com.example.aprovaai.ui.components.ConteudoListItem

//tela de conteúdos
@Composable
fun ConteudosScreen(
    conteudos: List<EstudosConteudos>,
    onConteudoSelected: (EstudosConteudos) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Conteúdos",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        LazyColumn {
            items(conteudos) { conteudo ->
                ConteudoListItem (
                    conteudo = conteudo,
                    onConteudoSelected = { selectedConteudo ->
                        onConteudoSelected(selectedConteudo)
                    }
                )
            }
        }
    }
}

