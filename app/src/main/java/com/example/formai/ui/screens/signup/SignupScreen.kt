package com.example.formai.ui.screens.signup

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.formai.domain.viewmodel.AuthViewModel
import com.example.formai.navigation.Route
import com.example.formai.ui.screens.AppButton
import com.example.formai.ui.screens.BackButtonLogInOrSignUp
import com.example.formai.ui.screens.CircularAppLogo
import com.example.formai.ui.screens.OrWithSocialsRow
import com.example.formai.ui.screens.SocialIconsRow
import com.example.formai.ui.screens.login.EmailAndPasswordTextBoxes
import com.example.formai.ui.screens.login.TrailingIcon
import com.example.formai.ui.theme.latoFont

// This page will hold the UI for signing up
@Composable
fun SignupScreen(
    navigateTo: (Route) -> Unit,
    authViewModel: AuthViewModel = hiltViewModel()
) {

    // Variables for recomposition
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var seePassword by remember { mutableStateOf(false) }
    var repeatPassword by remember { mutableStateOf("") }

    val authenticatedSuccessfully by authViewModel.authenticatedSuccessfully
    LaunchedEffect(authenticatedSuccessfully) {
        Log.d("LogIn", "Here we should navigate to a new screen as authentication is successful" +
                "the value of our authentication success is ${authViewModel.authenticatedSuccessfully.value}")
        if (authenticatedSuccessfully) {
            authViewModel.clearFields()
            navigateTo(Route.Main)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            BackButtonLogInOrSignUp(
                modifier = Modifier
                    .size(26.dp, 30.dp)
                    .fillMaxWidth(),
                navigateTo,
                Route.Welcome
            )
            CircularAppLogo(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 35.dp)
            )
        }

        Text(
            "Signup",
            fontSize = 24.sp,
            fontFamily = latoFont,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 20.dp, bottom = 8.dp)
        )

        EmailAndPasswordTextBoxes(value = email,
            onValueChange = {
                email = it
                authViewModel.email.value = email
                Log.d("Email", "Value of email is: $email")
            },
            modifier = Modifier
                .padding(top = 4.dp)
                .width(350.dp)
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            placeholder = {
                Text(
                    "Enter your email", fontWeight = FontWeight.Light
                )
            })

        EmailAndPasswordTextBoxes(
            value = password,
            onValueChange = {
                password = it
                authViewModel.password.value = password
                Log.d("Password", "Value of the password is: $password")
            },
            modifier = Modifier
                .padding(top = 32.dp)
                .width(350.dp)
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            placeholder = {
                Text(
                    "Enter your password", fontWeight = FontWeight.Light
                )
            },
            isPassword = true,
            seePassword = seePassword,

            ) { TrailingIcon(seePassword) { seePassword = !seePassword } }

        EmailAndPasswordTextBoxes(
            value = repeatPassword,
            onValueChange = {
                repeatPassword = it
                authViewModel.confirmPassword.value = repeatPassword
                Log.d("Password", "Value of the reentered password is: $repeatPassword")
            },
            modifier = Modifier
                .padding(top = 32.dp)
                .width(350.dp)
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            placeholder = {
                Text(
                    "Re-enter your password", fontWeight = FontWeight.Light
                )
            },
            isPassword = true,
            seePassword = seePassword,

            ) { TrailingIcon(seePassword) { seePassword = !seePassword } }

        Spacer(modifier = Modifier.height(24.dp))

        AppButton(modifier = Modifier
            .width(350.dp)
            .height(60.dp)
            .align(Alignment.CenterHorizontally),
            contentColor = Color.White,
            containerColor = Color(0xFF014863),
            shape = RoundedCornerShape(15.dp),
            onClickAction = {
                authViewModel.signUp()
            },
            content = {
                Text(text = "Sign Up", fontFamily = latoFont, fontSize = 16.sp)
            })

        if (authViewModel.errorMessage.value != null) {
            Text(
                "An Error Occured with Logging In",
                color = Color.Red, fontSize = 20.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(8.dp)
            )

            Log.d("Authentication", "The error message is: ${authViewModel.errorMessage.value}")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignupScreenPreview() {
    SignupScreen(navigateTo = {})
}
