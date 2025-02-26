package com.example.aprovaai.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.aprovaai.data.local.AppDatabase
import com.example.aprovaai.data.local.EstudosConteudosEntity
import com.example.aprovaai.data.repository.EstudosConteudosRepository
import com.example.aprovaai.models.EstudosConteudos
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class EstudosConteudosViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: EstudosConteudosRepository

    init {
        val estudosConteudosDao = AppDatabase.getDatabase(application).estudosConteudosDao()
        repository = EstudosConteudosRepository(estudosConteudosDao)
    }

    val conteudos: StateFlow<List<EstudosConteudosEntity>> = repository.getTodosConteudos().stateIn(
        viewModelScope,
        SharingStarted.Lazily,
        emptyList()
    )

    // Função de conversão
    fun toEstudosConteudosEntity(
        conteudos: EstudosConteudos,
        dataEstudo: String,
        dificuldade: String,
        hora: Int,
        minuto: Int
    ): EstudosConteudosEntity {
        return EstudosConteudosEntity(
            name = conteudos.name,
            dataEstudo = dataEstudo,
            dificuldade = dificuldade,
            checkEstudo = conteudos.checkEstudo,
            resolucao = conteudos.resolucao,
            isRevisar = conteudos.isRevisar,
            anotacoes = conteudos.anotacoes,
            hora = hora,
            minuto = minuto
        )
    }

    // Função para salvar o conteúdo convertido
    fun salvarConteudo(
        conteudo: EstudosConteudos,
        dataEstudo: String,
        dificuldade: String,
        hora: Int,
        minuto: Int
    ) {
        viewModelScope.launch {
            val conteudoEntity = toEstudosConteudosEntity(conteudo, dataEstudo, dificuldade, hora, minuto)

            Log.d("ViewModel", "Salvando no banco: $conteudoEntity") // Log para debug

            // Use salvarOuAtualizarConteudo para garantir que seja inserido ou atualizado
            repository.salvarOuAtualizarConteudo(conteudoEntity)

            Log.d("ViewModel", "Conteúdo salvo com sucesso")
        }
    }

}
