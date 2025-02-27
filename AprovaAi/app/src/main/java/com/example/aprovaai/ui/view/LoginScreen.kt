package com.example.aprovaai.ui.view

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.aprovaai.R
import com.example.aprovaai.ui.viewmodel.AuthViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException

@Composable
fun LoginScreen(viewModel: AuthViewModel, navController: NavController) {
    val context = LocalContext.current
    val activity = context as? Activity

    if (activity == null) {
        Toast.makeText(context, "Erro: contexto não é uma Activity", Toast.LENGTH_SHORT).show()
        return
    }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isVisible = true
    }

    val googleSignInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
        try {
            val account = task.getResult(ApiException::class.java)
            account?.idToken?.let { idToken ->
                viewModel.loginWithGoogle(idToken) { success ->
                    if (success) {
                        navController.navigate("home")
                    } else {
                        Toast.makeText(context, "Erro ao fazer login com Google", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        } catch (e: ApiException) {
            Toast.makeText(context, "Erro: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    val githubSignInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val data: Intent? = result.data
        val authCode = data?.getStringExtra("authCode")  // Este "authCode" pode vir da Intent de retorno do GitHub
        if (authCode != null) {
            // A função loginWithGitHub deve passar a Activity em vez do authCode
            viewModel.loginWithGitHub(activity) { success ->
                if (success) {
                    navController.navigate("home")
                } else {
                    Toast.makeText(context, "Erro ao fazer login com GitHub", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(context, "Falha ao obter código de autenticação do GitHub", Toast.LENGTH_SHORT).show()
        }
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
                Text("Bem-vindo ao Aprova Aí!", fontSize = 30.sp, style = MaterialTheme.typography.headlineLarge)

                Spacer(modifier = Modifier.height(16.dp))

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

                Spacer(modifier = Modifier.height(6.dp))

                Button(
                    onClick = {
                        viewModel.login(email, password) { success ->
                            if (success) {
                                navController.navigate("home")
                            } else {
                                Toast.makeText(context, "Usuário ou senha inválida", Toast.LENGTH_SHORT).show()
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Entrar", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = {
                        val signInIntent = viewModel.getGoogleSignInClient(context).signInIntent
                        googleSignInLauncher.launch(signInIntent)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google Login",
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text("Entrar com Google", fontSize = 18.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))

//                Button(
//                    onClick = {
//                        val githubIntent = viewModel.getGitHubSignInIntent()
//                        githubSignInLauncher.launch(githubIntent)
//                    },
//                    modifier = Modifier.fillMaxWidth(),
//                    shape = RoundedCornerShape(8.dp),
//                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.github),
//                        contentDescription = "GitHub Login",
//                        modifier = Modifier.size(24.dp)
//                    )
//
//                    Spacer(modifier = Modifier.width(8.dp))
//
//                    Text("Entrar com GitHub", fontSize = 18.sp)
//                }

                TextButton(onClick = { navController.navigate("register") }) {
                    Text("Criar Conta")
                }

                TextButton(onClick = { navController.navigate("forgotPassword") }) {
                    Text("Esqueci minha senha")
                }
            }
        }
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: ImageVector,
    isPassword: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = { Icon(icon, contentDescription = null) },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    )
}

