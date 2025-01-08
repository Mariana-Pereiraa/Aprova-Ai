package com.example.aprovaai.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aprovaai.models.Disciplina
import androidx.compose.material3.*
import androidx.compose.ui.unit.sp
import com.example.aprovaai.models.EstudosConteudos
import com.example.aprovaai.ui.theme.BlueBase
import com.example.aprovaai.ui.theme.GrayLight


@Composable
fun ConteudoListItem(
    conteudo: EstudosConteudos,
    onConteudoSelected: (EstudosConteudos) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(80.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = GrayLight)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center, // Centraliza o conteúdo verticalmente
            horizontalAlignment = Alignment.CenterHorizontally // Centraliza o conteúdo horizontalmente
        ) {
            Button(
                onClick = { onConteudoSelected(conteudo) },
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(0.8f), // Ajuste a largura do botão para não ocupar toda a largura
                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 2.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BlueBase)
            ) {
                Text(text = "${conteudo.name}", fontSize = 17.sp)
            }
        }
    }
}