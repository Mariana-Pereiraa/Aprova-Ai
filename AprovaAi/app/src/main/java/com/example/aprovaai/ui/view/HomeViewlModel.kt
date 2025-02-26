package com.example.aprovaai.ui.view

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.example.aprovaai.models.Disciplina

// ViewModel da tela de home, vai auxiliar a manter os dados de pesquisas recentes salvas
class HomeViewModel : ViewModel() {
    val recentsSearches = mutableStateListOf<Disciplina>()
}