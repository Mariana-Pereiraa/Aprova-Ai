package com.example.aprovaai.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface EstudosConteudosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun salvarConteudo(conteudo: EstudosConteudosEntity)

    @Query("SELECT * FROM estudos_conteudos")
    fun buscarTodosConteudos(): Flow<List<EstudosConteudosEntity>>

    @Delete
    suspend fun deletarConteudo(conteudo: EstudosConteudosEntity)

    @Update
    suspend fun atualizarConteudo(conteudo: EstudosConteudosEntity)

    @Query("SELECT * FROM estudos_conteudos WHERE id = :id LIMIT 1")
    suspend fun buscarConteudoPorId(id: Int): EstudosConteudosEntity?
}
