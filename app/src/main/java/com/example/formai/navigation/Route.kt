package com.example.formai.navigation

import kotlinx.serialization.Serializable
import java.io.Serial

sealed interface Route {

    @Serializable
    object Splash : Route

    @Serializable
    object LogIn : Route

    @Serializable
    object ForgotPassword : Route

    @Serializable
    object SignUp : Route

    @Serializable
    object Profile : Route

}