package com.example.aprovaai.data

import android.app.Activity
import android.util.Log
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.auth.OAuthProvider
import kotlinx.coroutines.tasks.await
import com.example.aprovaai.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.GoogleAuthProvider
import okhttp3.OkHttpClient

class AuthRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    private val clientId = "Ov23lieV5UyNwLXEntkq"  // Substitua com seu Client ID do GitHub
    private val redirectUri = "https://aprovaai-eec33.firebaseapp.com/__/auth/handler" // Redirect URI do Firebase
    private val httpClient = OkHttpClient()

    suspend fun registerUser(
        email: String,
        password: String,
        name: String
    ): Boolean {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val uid = result.user?.uid

            if (uid != null) {
                val user = hashMapOf(
                    "uid" to uid,
                    "name" to name,
                    "email" to email,
                    "created_at" to System.currentTimeMillis()
                )
                firestore.collection("users").document(uid).set(user).await()
            }
            true
        } catch (e: Exception) {
            Log.e("AuthRepository", "Erro no cadastro: ${e.message}")
            false
        }
    }

    suspend fun loginUser(
        email: String,
        password: String
    ): Boolean {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            true
        } catch (e: Exception) {
            Log.e("AuthRepository", "Erro no login: ${e.message}")
            false
        }
    }

    suspend fun resetPassword(email: String): Boolean {
        return try {
            auth.sendPasswordResetEmail(email).await()
            true
        } catch (e: Exception) {
            Log.e("AuthRepository", "Erro ao enviar email de recuperação: ${e.message}")
            false
        }
    }

    suspend fun getUserName(): String? {
        return try {
            val uid = auth.currentUser?.uid
            if (uid != null) {
                val snapshot = firestore.collection("users").document(uid).get().await()
                snapshot.getString("name")
            } else {
                null
            }
        } catch (e: Exception) {
            Log.e("AuthRepository", "Erro ao buscar nome do usuário: ${e.message}")
            null
        }
    }

    fun getGoogleSignInClient(context: Context): GoogleSignInClient {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(context.getString(com.example.aprovaai.R.string.default_web_client_id)) // Substitua pelo correto
            .requestEmail()
            .build()

        return GoogleSignIn.getClient(context, gso)
    }

    suspend fun loginWithGoogle(idToken: String): Boolean {
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val result = auth.signInWithCredential(credential).await()
            val user = result.user

            user?.let {
                val uid = it.uid
                val name = it.displayName ?: "Usuário"
                val email = it.email ?: ""

                val userRef = firestore.collection("users").document(uid)
                val snapshot = userRef.get().await()

                if (!snapshot.exists()) {
                    val userData = hashMapOf(
                        "uid" to uid,
                        "name" to name,
                        "email" to email,
                        "created_at" to System.currentTimeMillis()
                    )
                    userRef.set(userData).await()
                }
            }
            true
        } catch (e: Exception) {
            Log.e("AuthRepository", "Erro no login com Google: ${e.message}")
            false
        }
    }

    suspend fun loginWithGitHub(activity: Activity): Boolean {
        return try {
            val provider = OAuthProvider.newBuilder("github.com")
                .setScopes(listOf("user", "public_repo", "read:org"))
                .build()

            val result = auth.startActivityForSignInWithProvider(activity, provider).await()

            val user = result.user
            user?.let {
                val uid = it.uid
                val name = it.displayName ?: "Usuário GitHub"
                val email = it.email ?: ""

                val userRef = firestore.collection("users").document(uid)
                val snapshot = userRef.get().await()

                // Se o usuário ainda não existir no Firestore, salva seus dados
                if (!snapshot.exists()) {
                    val userData = hashMapOf(
                        "uid" to uid,
                        "name" to name,
                        "email" to email,
                        "created_at" to System.currentTimeMillis()
                    )
                    userRef.set(userData).await()
                }
            }
            true
        } catch (e: Exception) {
            Log.e("AuthRepository", "Erro no login com GitHub: ${e.message}")
            false
        }
    }

    fun getGitHubSignInIntent(): Intent {
        val authUrl = "https://github.com/login/oauth/authorize?client_id=$clientId&redirect_uri=$redirectUri&scope=user"
        return Intent(Intent.ACTION_VIEW, Uri.parse(authUrl))
    }

    fun logout() {
        auth.signOut()
    }

    fun isUserLogged(): Boolean {
        return auth.currentUser != null
    }
}
