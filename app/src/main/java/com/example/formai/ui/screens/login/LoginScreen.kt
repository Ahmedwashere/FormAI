package com.example.formai.ui.screens.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.formai.R
import com.example.formai.domain.viewmodel.AuthViewModel
import com.example.formai.navigation.Route
import com.example.formai.ui.screens.AppButton
import com.example.formai.ui.screens.BackButtonLogInOrSignUp
import com.example.formai.ui.screens.CircularAppLogo
import com.example.formai.ui.screens.OrWithSocialsRow
import com.example.formai.ui.screens.SocialIconsRow
import com.example.formai.ui.theme.latoFont

@Composable
fun LoginScreen(
    navigateTo: (Route) -> Unit,
    authViewModel: AuthViewModel = hiltViewModel()
) {

    // Variables for recomposition
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var seePassword by remember { mutableStateOf(false) }

    //Use a launched effect function which will navigate for us when the state in the viewmodel
    // changes

    val authenticatedSuccessfully by authViewModel.authenticatedSuccessfully
    LaunchedEffect(authenticatedSuccessfully) {
        Log.d("LogIn", "Here we should navigate to a new screen as authentication is successful" +
                "the value of our authentication success is ${authViewModel.authenticatedSuccessfully.value}")
        Log.d("NAVIGATE", "The value of isAuthenticated: $authenticatedSuccessfully")
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
            "Welcome Back!",
            fontSize = 24.sp,
            fontFamily = latoFont,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp, bottom = 16.dp)
        )

        Text(
            "Login",
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

        Text(
            "Forget your password?",
            fontSize = 16.sp,
            fontFamily = latoFont,
            modifier = Modifier.padding(top = 16.dp, start = 210.dp, bottom = 32.dp)
        )

        AppButton(modifier = Modifier
            .width(350.dp)
            .height(60.dp)
            .align(Alignment.CenterHorizontally),
            contentColor = Color.White,
            containerColor = Color(0xFF014863),
            shape = RoundedCornerShape(15.dp),
            onClickAction = {
                authViewModel.signIn()
            },
            content = {
                Text(text = "Login", fontFamily = latoFont, fontSize = 16.sp)
            })

        if (authViewModel.errorMessage.value != null) {
            Text(
                "An Error Occured with Logging In",
                color = Color.Red, fontSize = 20.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(8.dp)
            )

            Log.d("Authentication", "The error message for login is: ${authViewModel.errorMessage.value}")
        }
    }
}

/**
 * Lets think about what this would need.
 *
 * Well for one, we need the placeholder sent in,
 *
 */
@Composable
fun EmailAndPasswordTextBoxes(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: @Composable () -> Unit,
    isPassword: Boolean = false,
    seePassword: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        shape = RoundedCornerShape(30),
        placeholder = placeholder,
        trailingIcon = trailingIcon,
        visualTransformation = if (!isPassword) {
            VisualTransformation.None
        } else {
            if (seePassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }
        }
    )
}

@Composable
fun TrailingIcon(
    seePassword: Boolean, onStateChange: () -> Unit
) {
    if (!seePassword) {
        Image(painter = painterResource(id = R.drawable.closed_eye),
            contentDescription = "closed eye ui icon",
            modifier = Modifier
                .size(30.dp)
                .padding(end = 2.dp)
                .clickable {
                    onStateChange()
                    Log.d("Password", "We don't see the password")
                })
    } else {
        Image(painter = painterResource(id = R.drawable.open_eye),
            contentDescription = "closed eye ui icon",
            modifier = Modifier
                .size(30.dp)
                .padding(end = 2.dp)
                .clickable {
                    onStateChange()
                    Log.d("Password", "We see the password")
                })
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(navigateTo = {})
}

@Preview(showBackground = true)
@Composable
fun EmailOutlinedTextFieldPreview() {
    // This returns a value that can cause UI recompositions for us
    var email by remember { mutableStateOf("") }

    EmailAndPasswordTextBoxes(value = email,
        onValueChange = {
            email = it
            Log.d("Email", "Value of email is: $email")
        },
        modifier = Modifier.padding(8.dp),
        placeholder = { Text("Enter your email", fontWeight = FontWeight.Light) })

}

@Preview(showBackground = true)
@Composable
fun PasswordOutlinedTextFieldPreview() {
    // This returns a value that can cause UI recompositions for us
    var password by remember { mutableStateOf("") }
    var see_password by remember { mutableStateOf(false) }

    EmailAndPasswordTextBoxes(value = password,
        onValueChange = {
            password = it
            Log.d("Email", "Value of email is: $password")
        },
        modifier = Modifier.padding(8.dp),
        placeholder = { Text("Enter your password", fontWeight = FontWeight.Light) },
        trailingIcon = {
            if (!see_password) {
                Image(painter = painterResource(id = R.drawable.closed_eye),
                    contentDescription = "closed eye ui icon",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 2.dp)
                        .clickable {
                            see_password = !see_password
                            Log.d("Password", "We don't see the password")
                        })
            } else {
                Image(painter = painterResource(id = R.drawable.open_eye),
                    contentDescription = "closed eye ui icon",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 2.dp)
                        .clickable {
                            see_password = !see_password
                            Log.d("Password", "We see the password")
                        })
            }
        })
}

/**
 * Something really cool about placeholder.
 *
 * Even though Placeholder is a text composable, it doesn't affect the mutable
 * value I send into the method!!
 *
 * Super useful as I can validate whether an email is valid/empty when the user
 * clicked the login button and before I send it over to firebase.
 */
@Preview(
    showBackground = true,
)
@Composable
fun LoginButtonPreview() {
    AppButton(modifier = Modifier
        .width(314.dp)
        .height(56.dp)
        .padding(4.dp),
        contentColor = Color.White,
        containerColor = Color(0xFF014863),
        shape = RoundedCornerShape(15.dp),
        onClickAction = {/* TODO 1: Implement Navigation and Logging in here*/ },
        content = {
            Text(text = "Login", fontFamily = latoFont)
        })
}




