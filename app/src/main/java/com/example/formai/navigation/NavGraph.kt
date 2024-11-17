package com.example.formai.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.formai.navigation.Route.Input
import com.example.formai.navigation.Route.LogIn
import com.example.formai.navigation.Route.Main
import com.example.formai.navigation.Route.Results
import com.example.formai.navigation.Route.SignUp
import com.example.formai.navigation.Route.Wall
import com.example.formai.navigation.Route.Welcome
import com.example.formai.navigation.Route.Workout
import com.example.formai.ui.screens.explore.ExploreScreen
import com.example.formai.ui.screens.input.SetPhoneAgainstWallScreen
import com.example.formai.ui.screens.input.VideoInputScreen
import com.example.formai.ui.screens.login.LoginScreen
import com.example.formai.ui.screens.results.ResultsScreen
import com.example.formai.ui.screens.signup.SignupScreen
import com.example.formai.ui.screens.welcome.WelcomeScreen
import com.example.formai.ui.screens.workout.CameraPreviewForWorkoutScreen

@Composable
fun navigation(): NavHostController {
    val navController = rememberNavController()

    val navRoutes = { route: Route ->
        when (route) {
            Welcome -> navController.navigate(Welcome.toString())
            LogIn -> navController.navigate(LogIn.toString())
            SignUp -> navController.navigate(SignUp.toString())
            Main -> navController.navigate(Main.toString())
            Input -> navController.navigate(Input.toString())
            Wall ->
                navController.navigate(Wall.toString()) {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                }

            Workout -> navController.navigate(Workout.toString())
            Results ->
                navController.navigate(Results.toString()) {
                    popUpTo(Workout.toString()) {
                        inclusive = true
                    }
                }
        }
    }

    NavHost(
        navController = navController,
        /** TODO: Change back to Welcome before you submit */
        startDestination = Main.toString(),
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
            ExploreScreen(navRoutes)
        }

        composable(Input.toString()) {
            VideoInputScreen(navRoutes)
        }

        composable(Wall.toString()) {
            SetPhoneAgainstWallScreen(navRoutes)
        }

        composable(Workout.toString()) {
            CameraPreviewForWorkoutScreen(navRoutes)
        }

        composable(Results.toString()) {
            ResultsScreen(navRoutes)
        }
    }

    return navController
}