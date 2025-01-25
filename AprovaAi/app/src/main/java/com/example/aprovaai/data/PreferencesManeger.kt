package com.example.aprovaai.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences


private val Context.dataStore by preferencesDataStore(name = "user_preferences")

object PreferencesManager {
    private val NOTIFICATIONS_KEY = booleanPreferencesKey("notifications_enabled")
    private val DARK_MODE_KEY = booleanPreferencesKey("dark_mode")

    // Obtém a instância única do DataStore
    private fun getDataStore(context: Context): DataStore<androidx.datastore.preferences.core.Preferences> {
        return context.dataStore
    }

    // Fluxo para observar se as notificações estão ativadas
    fun notificationsEnabledFlow(context: Context): Flow<Boolean> {
        return getDataStore(context).data
            .map { preferences ->
                preferences[NOTIFICATIONS_KEY] ?: false // Falso por padrão
            }
    }

    // Atualiza o estado das notificações no DataStore
    suspend fun setNotificationsEnabled(context: Context, enabled: Boolean) {
        getDataStore(context).edit { preferences ->
            preferences[NOTIFICATIONS_KEY] = enabled
        }
    }

    // Obtém o estado do modo escuro armazenado
    fun darkModeFlow(context: Context): Flow<Boolean> {
        return getDataStore(context).data
            .map { preferences ->
                preferences[DARK_MODE_KEY] ?: false // Falso por padrão
            }
    }

    // Atualiza o estado do modo escuro no DataStore
    suspend fun setDarkMode(context: Context, enabled: Boolean) {
        getDataStore(context).edit { preferences ->
            preferences[DARK_MODE_KEY] = enabled
        }
    }
}