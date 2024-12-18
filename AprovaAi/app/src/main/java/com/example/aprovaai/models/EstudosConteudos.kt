package com.example.aprovaai.models

import java.util.Date

data class EstudosConteudos(
    val dataEstudo: Date,
    val dificuldade: Dificuldade,
    var checkEstudo: Boolean = false,
    var resolucao: Boolean = false,
    var revisar: Boolean = false,
    var anotacoes: String = ""
)

enum class Dificuldade {
    FÁCIL,
    MÉDIO,
    DIFÍCIL
}
