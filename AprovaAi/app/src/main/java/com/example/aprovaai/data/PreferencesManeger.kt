package com.example.aprovaai.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_preferences")

object PreferencesManager {
    private val NOTIFICATIONS_KEY = booleanPreferencesKey("notifications_enabled")
    private val DARK_MODE_KEY = booleanPreferencesKey("dark_mode")
    private val ANIMATIONS_KEY = booleanPreferencesKey("animations_enabled") // Adicionando a chave

    private fun getDataStore(context: Context): DataStore<androidx.datastore.preferences.core.Preferences> {
        return context.dataStore
    }

    // Notificações
    fun notificationsEnabledFlow(context: Context): Flow<Boolean> {
        return getDataStore(context).data.map { preferences ->
            preferences[NOTIFICATIONS_KEY] ?: false
        }
    }

    suspend fun setNotificationsEnabled(context: Context, enabled: Boolean) {
        getDataStore(context).edit { preferences ->
            preferences[NOTIFICATIONS_KEY] = enabled
        }
    }

    // Modo escuro
    fun darkModeFlow(context: Context): Flow<Boolean> {
        return getDataStore(context).data.map { preferences ->
            preferences[DARK_MODE_KEY] ?: false
        }
    }

    suspend fun setDarkMode(context: Context, enabled: Boolean) {
        getDataStore(context).edit { preferences ->
            preferences[DARK_MODE_KEY] = enabled
        }
    }

    // **Animações**
    fun animationsEnabledFlow(context: Context): Flow<Boolean> {
        return getDataStore(context).data.map { preferences ->
            preferences[ANIMATIONS_KEY] ?: true // Ativado por padrão
        }
    }

    suspend fun setAnimationsEnabled(context: Context, enabled: Boolean) {
        getDataStore(context).edit { preferences ->
            preferences[ANIMATIONS_KEY] = enabled
        }
    }
}
