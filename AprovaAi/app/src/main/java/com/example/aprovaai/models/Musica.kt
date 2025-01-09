package com.example.aprovaai.models
import com.example.aprovaai.R

data class Musica (
    val id: Int,
    val nome: String,
    val soundRes: Int
)


val musicas = listOf(
    Musica(1, "Ambiente Escuro", R.raw.ambienteescuro),
    Musica(2, "Canto de Pássaro", R.raw.cantodepassaro),
    Musica(3, "Chuva", R.raw.chuva),
    Musica(4, "Chuva na Janela", R.raw.chuvanajanela),
    Musica(5, "Ruído Marrom", R.raw.ruidomarrom),
    Musica(6, "Ruído Rosa", R.raw.ruidorosa),
    Musica(7, "Som de Água", R.raw.somdeagua),
    Musica(8, "Tictac", R.raw.tictac)
)

