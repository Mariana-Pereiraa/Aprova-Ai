//package com.example.aprovaai.data
//
//import android.content.Context
//import androidx.datastore.preferences.core.booleanPreferencesKey
//import androidx.datastore.preferences.core.edit
//import androidx.datastore.preferences.preferencesDataStore
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//
//private val Context.dataStore by preferencesDataStore(name = "user_preferences")
//
//class PreferencesNotifications private constructor(private val context: Context) {
//    companion object {
//        // Usando o padrão Singleton para garantir uma única instância
//        @Volatile
//        private var INSTANCE: PreferencesNotifications? = null
//
//        private val NOTIFICATIONS_KEY = booleanPreferencesKey("notifications_enabled")
//
//        // Função para obter a instância única de PreferencesNotifications
//        fun getInstance(context: Context): PreferencesNotifications {
//            return INSTANCE ?: synchronized(this) {
//                INSTANCE ?: PreferencesNotifications(context).also {
//                    INSTANCE = it
//                }
//            }
//        }
//    }
//
//    // Fluxo para observar se as notificações estão ativadas
//    val notificationsEnabledFlow: Flow<Boolean> = context.dataStore.data
//        .map { preferences ->
//            preferences[NOTIFICATIONS_KEY] ?: false // Falso por padrão
//        }
//
//    // Função suspensa para atualizar as preferências
//    suspend fun setNotificationsEnabled(enabled: Boolean) {
//        context.dataStore.edit { preferences ->
//            preferences[NOTIFICATIONS_KEY] = enabled
//        }
//    }
//}