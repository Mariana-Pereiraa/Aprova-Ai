package com.example.aprovaai

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.aprovaai.navigation.NavGraph
import com.example.aprovaai.ui.theme.AprovaAiTheme
import com.example.aprovaai.ui.viewmodel.ThemeViewModel
import com.example.aprovaai.data.PreferencesManager
import androidx.core.app.ActivityCompat
import android.content.pm.PackageManager
import android.util.Log

class MainActivity : ComponentActivity() {
    private val themeViewModel by viewModels<ThemeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            requestNotificationPermission()

            setContent {
                val isDarkMode by PreferencesManager.darkModeFlow(this).collectAsStateWithLifecycle(initialValue = false)
                val notificationsEnabled by PreferencesManager.notificationsEnabledFlow(this).collectAsStateWithLifecycle(initialValue = false)

                AprovaAiTheme(darkTheme = isDarkMode) {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        val navController = rememberNavController()
                        NavGraph(
                            onSettingsClick = {

                            },
                            onHelpClick = {

                            }
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
}
