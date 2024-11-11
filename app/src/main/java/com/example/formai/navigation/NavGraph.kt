package com.example.formai.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.formai.navigation.Route.LogIn
import com.example.formai.navigation.Route.Main
import com.example.formai.navigation.Route.SignUp
import com.example.formai.navigation.Route.Welcome
import com.example.formai.ui.screens.explore.ExploreScreen
import com.example.formai.ui.screens.login.LoginScreen
import com.example.formai.ui.screens.signup.SignupScreen
import com.example.formai.ui.screens.welcome.WelcomeScreen

@Composable
fun navigation(): NavHostController {
    val navController = rememberNavController()

    val navRoutes = { route: Route ->
        when(route) {
            Welcome -> navController.navigate(Welcome.toString())
            LogIn -> navController.navigate(LogIn.toString())
            SignUp -> navController.navigate(SignUp.toString())
            Main -> navController.navigate(Main.toString())
        }
    }

    NavHost(
        navController = navController,
        startDestination = Welcome.toString(),
    ) {
        composable(Welcome.toString()) {
            WelcomeScreen(navRoutes)
        }

        composable(LogIn.toString()) {
            LoginScreen(navRoutes)
        }

        composable(SignUp.toString()) {
            SignupScreen(navRoutes)
        }

        composable(Main.toString()) {
            /** TODO: Add the Main Screen to the Application */
            ExploreScreen()
        }
    }

    return navController
}