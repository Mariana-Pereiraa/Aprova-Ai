package com.example.aprovaai.data.repository

import android.util.Log
import com.example.aprovaai.data.local.EstudosConteudosDao
import com.example.aprovaai.data.local.EstudosConteudosEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EstudosConteudosRepository @Inject constructor(
    private val estudosConteudosDao: EstudosConteudosDao
) {

    // Método para obter todos os conteúdos de estudo
    fun getTodosConteudos(): Flow<List<EstudosConteudosEntity>> {
        return estudosConteudosDao.buscarTodosConteudos()
    }

    // Método para salvar um conteúdo de estudo
    suspend fun salvarConteudo(conteudo: EstudosConteudosEntity) {
        Log.d("EstudosConteudosRepository", "Salvando Conteudo: ${conteudo.name}")
        estudosConteudosDao.salvarConteudo(conteudo)
    }

    // Método para deletar um conteúdo de estudo
    suspend fun deletarConteudo(conteudo: EstudosConteudosEntity) {
        estudosConteudosDao.deletarConteudo(conteudo)
    }

    suspend fun atualizarConteudo(conteudo: EstudosConteudosEntity) {
        estudosConteudosDao.atualizarConteudo(conteudo)
    }

    

    suspend fun salvarOuAtualizarConteudo(conteudo: EstudosConteudosEntity) {
        if (conteudo.id == 0) {
            estudosConteudosDao.salvarConteudo(conteudo) // Insere novo
        } else {
            val existente = estudosConteudosDao.buscarConteudoPorId(conteudo.id)
            if (existente == null) {
                estudosConteudosDao.salvarConteudo(conteudo) // Insere novo
            } else {
                estudosConteudosDao.atualizarConteudo(conteudo) // Atualiza existente
            }
        }
    }


}
