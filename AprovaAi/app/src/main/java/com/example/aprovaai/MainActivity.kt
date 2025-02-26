package com.example.aprovaai

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aprovaai.data.AuthRepository
import com.example.aprovaai.data.PreferencesManager
import com.example.aprovaai.data.local.AppDatabase
import com.example.aprovaai.data.repository.EstudosConteudosRepository
import com.example.aprovaai.navigation.NavGraph
import com.example.aprovaai.ui.theme.AprovaAiTheme
import com.example.aprovaai.ui.view.ForgotPasswordScreen
import com.example.aprovaai.ui.view.HomeLoginScreen
import com.example.aprovaai.ui.view.LoginScreen
import com.example.aprovaai.ui.view.RegisterScreen
import com.example.aprovaai.ui.viewmodel.AuthViewModel
import com.example.aprovaai.ui.viewmodel.AuthViewModelFactory
import com.example.aprovaai.ui.viewmodel.EstudosConteudosViewModel
import com.example.aprovaai.ui.viewmodel.EstudosConteudosViewModelFactory
import com.example.aprovaai.ui.viewmodel.ThemeViewModel
import kotlinx.coroutines.launch
import java.util.Calendar

class MainActivity : ComponentActivity() {
    private val themeViewModel by viewModels<ThemeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = AuthRepository()
        val authViewModel = ViewModelProvider(this, AuthViewModelFactory(repository)).get(
            AuthViewModel::class.java
        )

        // Instancie o EstudosConteudosViewModel manualmente
        val estudosConteudosViewModel = ViewModelProvider(
            this,
            EstudosConteudosViewModelFactory(application)
        ).get(EstudosConteudosViewModel::class.java)

        try {
            requestNotificationPermission()

            lifecycleScope.launch {
                checkAndSetDarkMode()
            }

            setContent {
                val isDarkMode by PreferencesManager.darkModeFlow(this).collectAsStateWithLifecycle(initialValue = false)
                val notificationsEnabled by PreferencesManager.notificationsEnabledFlow(this).collectAsStateWithLifecycle(initialValue = false)

                AprovaAiTheme(darkTheme = isDarkMode) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        NavGraph(
                            onSettingsClick = { /* ... */ },
                            onHelpClick = { /* ... */ },
                            viewModel = authViewModel,
                            estudosConteudosViewModel = estudosConteudosViewModel // Passe o ViewModel
                        )
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "Erro ao iniciar o aplicativo", e)
        }
    }

    private fun requestNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 123)
            }
        }
    }

    private suspend fun checkAndSetDarkMode() {
        val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val isNightMode = hour >= 18 || hour <= 6

        PreferencesManager.setDarkMode(this, isNightMode)

        if (isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}