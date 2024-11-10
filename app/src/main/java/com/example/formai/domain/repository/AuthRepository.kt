package com.example.formai.domain.repository

import com.example.formai.domain.model.Response
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

typealias SignUpResponse = Response<Boolean>
typealias LogInResponse = Response<Boolean>
typealias ReloadUserResponse = Response<Boolean>
typealias SendPasswordResetEmailResponse = Response<Boolean>
typealias AuthStateResponse = Flow<Boolean>

interface AuthRepository {
    val currentUser: FirebaseUser?

    suspend fun signUpWithEmailAndPassword(email: String, password: String): SignUpResponse

    suspend fun loginWithEmailAndPassword(email: String, password: String): LogInResponse

    suspend fun reloadUser(): ReloadUserResponse

    suspend fun sendPasswordResetEmail(email: String): SendPasswordResetEmailResponse

    fun signOut()

    fun getAuthState(): AuthStateResponse
}

