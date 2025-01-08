package com.example.aprovaai.ui.screens

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf
import com.example.aprovaai.models.Disciplina

class HomeViewModel : ViewModel() {
    val recentsSearches = mutableStateListOf<Disciplina>()
}