package com.example.aprovaai.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aprovaai.ui.theme.AprovaAiTheme

//tela de configuraçãoes que vai ser acionada no menu tres pontinhos
@Composable
fun SettingsScreen(
    isDarkModeEnabled: Boolean,
    onDarkModeToggle: (Boolean) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Configurações",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
        ) {
            Text(
                text = "Modo Escuro",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = isDarkModeEnabled,
                onCheckedChange = { onDarkModeToggle(it) }
            )
        }
    }
}

@Preview
@Composable
fun SettingsScreenPreview() {
    val isDarkMode = remember { mutableStateOf(false) }

    AprovaAiTheme(darkTheme = isDarkMode.value) {
        Surface {
            SettingsScreen(
                isDarkModeEnabled = isDarkMode.value,
                onDarkModeToggle = { isDarkMode.value = it }
            )
        }
    }
}