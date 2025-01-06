package com.example.aprovaai.models

import java.util.Date

data class EstudosConteudos(
    val id: Int,
    var name: String = "",
    val dataEstudo: Date,
    val dificuldade: Dificuldade,
    var checkEstudo: Boolean = false,
    var resolucao: Boolean = false,
    var isRevisar: Boolean = false,
    var anotacoes: String = ""
)

enum class Dificuldade {
    FÁCIL,
    MÉDIO,
    DIFÍCIL
}
