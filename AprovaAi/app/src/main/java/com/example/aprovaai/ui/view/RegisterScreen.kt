package com.example.aprovaai.ui.view

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aprovaai.ui.viewmodel.AuthViewModel

@Composable
fun RegisterScreen(viewModel: AuthViewModel, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        isVisible = true
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically() + fadeIn()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Criar Conta", fontSize = 30.sp, style = MaterialTheme.typography.headlineLarge)

                Spacer(modifier = Modifier.height(16.dp))

                CustomTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = "Nome",
                    icon = Icons.Filled.Person
                )

                CustomTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = "Email",
                    icon = Icons.Filled.Email
                )

                CustomTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = "Senha",
                    icon = Icons.Filled.Lock,
                    isPassword = true
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        viewModel.register(email, password, name) { success ->
                            if (success) {
                                navController.popBackStack() // Isso garante que o usuário seja levado de volta para a tela de login
                                navController.navigate("login") // Vai para a tela de login
                            } else {
                                navController.popBackStack()
                                navController.navigate("login")
                            }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Registrar", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))

                TextButton(onClick = { navController.navigate("login") }) {
                    Text("Já tem uma conta? Faça login")
                }
            }
        }
    }
}
