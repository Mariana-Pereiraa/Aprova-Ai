package com.example.aprovaai.models
import java.util.Date
import com.example.aprovaai.R



data class Disciplina(
    val id: Int,
    val name: String,
    val imageDisc: Int,
    val conteudos: EstudosConteudos,
)

    val disciplinasList = listOf(
        Disciplina(
            id = 1 ,
            name = "Português",
            imageDisc = R.drawable.portugues,
            conteudos = EstudosConteudos(
                id = 1,
                name = "Gramática",
                dataEstudo = Date(),
                dificuldade = Dificuldade.FÁCIL,
                checkEstudo = false,
                resolucao = false,
                anotacoes = "Estudar gramática"
            )
        ),
        Disciplina(
            id = 2,
            name = "Matemática",
            imageDisc = R.drawable.matematica,
            conteudos = EstudosConteudos(
                id = 2 ,
                name = "Probabilidade",
                dataEstudo = Date(),
                dificuldade = Dificuldade.DIFÍCIL,
                checkEstudo = false,
                resolucao = true,
                anotacoes = "Praticar exercícios de probabilidade"
            )
        )
    )

    fun getConteudosByDisciplina(disciplina: String): EstudosConteudos? {
        return disciplinasList.find { it.name.equals(disciplina, ignoreCase = true) }?.conteudos
    }