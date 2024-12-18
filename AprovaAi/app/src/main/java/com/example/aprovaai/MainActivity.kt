package com.example.aprovaai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.navigation.compose.rememberNavController
import com.example.aprovaai.navigation.NavGraph
import com.example.aprovaai.ui.theme.AprovaAiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AprovaAiTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
