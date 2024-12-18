package com.example.aprovaai.models
import com.example.aprovaai.R
import java.util.Date
import com.example.aprovaai.models.EstudosConteudos


class Disciplinas {
    val portuguesConteudos = EstudosConteudos(
        dataEstudo = Date(),
        dificuldade = Dificuldade.FÁCIL,
        checkEstudo = false,
        resolucao = false,
        revisar = false,
        anotacoes = ""
    )

    val matematicaConteudos = EstudosConteudos(
        dataEstudo = Date(),
        dificuldade = Dificuldade.DIFÍCIL,
        checkEstudo = false,
        resolucao = true,
        revisar = false,
        anotacoes = "Praticar exercícios de probabilidade"
    )

    fun getConteudosByDsciplinas(disciplina: String): EstudosConteudos{
        return when(disciplina){
            "Português" -> portuguesConteudos
            "Matemática" -> matematicaConteudos
            else -> EstudosConteudos(Date(), Dificuldade.FÁCIL)
        }
    }
}