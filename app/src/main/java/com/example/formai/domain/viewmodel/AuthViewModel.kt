package com.example.formai.domain.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.formai.domain.model.Response
import com.example.formai.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    // State variables
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    val confirmPassword = mutableStateOf("")
    val isLoading = mutableStateOf(false)

    // Makes it s that the errorMessage can be empty if we would like it to be
    val errorMessage = mutableStateOf<String?>(null)

    // Check if the user is authenticated successfully
    val authenticatedSuccessfully = mutableStateOf(false)

    // Function to clear the state variables
    fun clearFields() {
        email.value = ""
        password.value = ""
        confirmPassword.value = ""
        errorMessage.value = null
        authenticatedSuccessfully.value = false
    }

    fun signUp() {
        if (password.value.trim() != confirmPassword.value.trim()) {
            errorMessage.value = "Passwords do not match"
            return
        }

        viewModelScope.launch {
            isLoading.value = true
            Log.d("SignUp", "The email and password before sending it to AuthRepository are" +
                    "(email: ${email.value} ,password: ${password.value}) ")
            val result = authRepository.signUpWithEmailAndPassword(email.value, password.value)
            isLoading.value = false
            handleAuthResult(result)
        }
    }

    fun signIn() {
        viewModelScope.launch {
            isLoading.value = true
            val result = authRepository.loginWithEmailAndPassword(email.value, password.value)
            isLoading.value = false
            handleAuthResult(result)
        }
    }

    fun handleAuthResult(response: Response<Boolean>) {
        when (response) {
            is Response.Success -> {
                Log.d("Authentication", "handleAuthResult: Success!")
                authenticatedSuccessfully.value = true
                Log.d("Authentication", authenticatedSuccessfully.value.toString())
            }

            is Response.Error -> {
                Log.d("Authentication", "handleAuthResult: Error (${response.exception.message})")
                errorMessage.value = response.exception.message
            }

            else -> {
                /** Do nothing, just log it*/
                Log.d("Authentication", "handleAuthResult: Loading -> Nothing")
            }
        }
    }
}