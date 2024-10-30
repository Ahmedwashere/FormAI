package com.example.formai.ui.screens.login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.formai.R
import com.example.formai.ui.screens.AppButton
import com.example.formai.ui.screens.BackButton
import com.example.formai.ui.screens.CircularAppLogo
import com.example.formai.ui.screens.OrWithSocialsRow
import com.example.formai.ui.theme.latoFont

/*
    General Structure:
        - A Column that contains all the elements.

        // Hard code this
        - An Image Element within a circle shape

        // Hard code
        - A text composable for the Welcome Back part

        - a Login text composable

        // Make a composable function for this
        // Look into documentation for the differences.
        - Two text field composables:
            1. email - placeholder - Enter your email
            2. password - enter your password

        // Composable function for this
        - A forget your password button

        // use ***WelcomeScreen button composable***
        -A login button

        // Hard code these in the column
        - a row composable:
            - line, text composable, line

        // Make a composable for the boxes.
        // Make it so that the onClick and image are dynamic here
        - a row composable:
            -three boxes with images nested within the boxes. Image should take up max width.
 */

@Composable
fun LoginScreen() {

    // Variables for recomposition
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var seePassword by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            BackButton(
                modifier = Modifier
                    .size(26.dp, 30.dp)
                    .fillMaxWidth()
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
                Log.d("Email", "Value of email is: $email")
            },
            modifier = Modifier
                .padding(top = 4.dp)
                .width(350.dp)
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            placeholder = {
                Text(
                    "Enter your email",
                    fontWeight = FontWeight.Light
                )
            })

        EmailAndPasswordTextBoxes(
            value = password,
            onValueChange = {
                password = it
                Log.d("Email", "Value of email is: $password")
            },
            modifier = Modifier
                .padding(top = 32.dp)
                .width(350.dp)
                .height(60.dp)
                .align(Alignment.CenterHorizontally),
            placeholder = {
                Text(
                    "Enter your password",
                    fontWeight = FontWeight.Light
                )
            }
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
            onClickAction = {/* TODO 1: Implement Navigation and Logging in here*/ },
            content = {
                Text(text = "Login", fontFamily = latoFont, fontSize = 16.sp)
            })

        OrWithSocialsRow(text = "Or Login With", modifier = Modifier.padding(top = 24.dp))


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
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        shape = RoundedCornerShape(30),
        placeholder = placeholder,
        trailingIcon = trailingIcon,
    )
}

@Composable
fun TrailingIcon(
    seePassword: Boolean,
    onStateChange: () -> Unit
) {
    if (!seePassword) {
        Image(
            painter = painterResource(id = R.drawable.closed_eye),
            contentDescription = "closed eye ui icon",
            modifier = Modifier
                .size(30.dp)
                .padding(end = 2.dp)
                .clickable {
                    onStateChange()
                    Log.d("Password", "We don't see the password")
                }
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.open_eye),
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
    LoginScreen()
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
                Image(
                    painter = painterResource(id = R.drawable.closed_eye),
                    contentDescription = "closed eye ui icon",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 2.dp)
                        .clickable {
                            see_password = !see_password
                            Log.d("Password", "We don't see the password")
                        }
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.open_eye),
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




