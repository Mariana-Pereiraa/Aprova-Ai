package com.example.aprovaai.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estudos_conteudos")
data class EstudosConteudosEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val dataEstudo: String,
    val dificuldade: String,
    val checkEstudo: Boolean,
    val resolucao: Boolean,
    val isRevisar: Boolean,
    val anotacoes: String,
    val hora: Int,
    val minuto: Int
)