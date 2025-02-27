package com.example.aprovaai.data

import android.util.Log
import com.example.aprovaai.models.Disciplina
import com.google.firebase.database.FirebaseDatabase

class FirebaseRepository {

    private val database = FirebaseDatabase.getInstance()
    private val usuariosRef = database.getReference("usuarios")

    // Atualiza a lista de favoritos do usuário
    fun atualizarFavoritos(userId: String, disciplina: Disciplina) {
        val favoritosRef = usuariosRef.child(userId).child("favoritos")

        if (disciplina.isFavorite) {
            // Adicionar ao banco de dados (convertendo disciplina.id para String)
            favoritosRef.child(disciplina.id.toString()).setValue(true)
                .addOnSuccessListener {
                    Log.d("Firebase", "Disciplina ${disciplina.id} favoritada!")
                }
                .addOnFailureListener { e ->
                    Log.e("Firebase", "Erro ao favoritar disciplina", e)
                }
        } else {
            // Remover do banco de dados (convertendo disciplina.id para String)
            favoritosRef.child(disciplina.id.toString()).removeValue()
                .addOnSuccessListener {
                    Log.d("Firebase", "Disciplina ${disciplina.id} removida dos favoritos!")
                }
                .addOnFailureListener { e ->
                    Log.e("Firebase", "Erro ao remover disciplina dos favoritos", e)
                }
        }
    }
}
