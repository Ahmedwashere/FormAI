package com.example.formai.domain.repository

import android.util.Log
import com.example.formai.domain.model.Response
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.trySendBlocking
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
): AuthRepository {

    // Gets the current user.
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String
    ): SignUpResponse {
        Log.d("SignUp", "The email and password before sending it to FIREBASE are" +
                "(email: $email ,password: $password) ")
        return try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            Response.Success(true)
        } catch (e: Exception) {
            Response.Error(e)        }
    }

    override suspend fun loginWithEmailAndPassword(email: String, password: String): LogInResponse {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Response.Success(true)
        } catch (e: Exception) {
            Response.Error(e)        }
    }

    override suspend fun reloadUser(): ReloadUserResponse {
        return try {
            firebaseAuth.currentUser?.reload()?.await()
            Response.Success(true)
        } catch (e: Exception) {
            Response.Error(e)        }
    }

    override suspend fun sendPasswordResetEmail(email: String): SendPasswordResetEmailResponse {
        return try {
            firebaseAuth.sendPasswordResetEmail(email).await()
            Response.Success(true)
        } catch (e: Exception) {
            Response.Error(e)
        }
    }

    override fun signOut() {
        firebaseAuth.signOut()
    }

    override fun getAuthState(): AuthStateResponse = callbackFlow {
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            trySendBlocking(auth.currentUser != null)
        }

        firebaseAuth.addAuthStateListener(authStateListener)

        awaitClose {
            firebaseAuth.removeAuthStateListener(authStateListener)
        }
    }
}