package com.example.aprovaai.ui.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EstudosConteudosViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EstudosConteudosViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EstudosConteudosViewModel(application) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}