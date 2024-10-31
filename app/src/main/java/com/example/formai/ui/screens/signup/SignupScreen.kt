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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.formai.ui.screens.AppButton
import com.example.formai.ui.screens.BackButton
import com.example.formai.ui.screens.CircularAppLogo
import com.example.formai.ui.screens.OrWithSocialsRow
import com.example.formai.ui.screens.SocialIconsRow
import com.example.formai.ui.screens.login.EmailAndPasswordTextBoxes
import com.example.formai.ui.screens.login.TrailingIcon
import com.example.formai.ui.theme.latoFont

// This page will hold the UI for signing up
@Composable
fun SignupScreen() {

    // Variables for recomposition
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var seePassword by remember { mutableStateOf(false) }
    var repeatPassword by remember { mutableStateOf("") }

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
            "Signup",
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
                    "Enter your email", fontWeight = FontWeight.Light
                )
            })

        EmailAndPasswordTextBoxes(
            value = password,
            onValueChange = {
                password = it
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
            onClickAction = {/* TODO 6: Implement Navigation and Signup in here*/ },
            content = {
                Text(text = "Sign Up", fontFamily = latoFont, fontSize = 16.sp)
            })

        OrWithSocialsRow(text = "Or Sign Up With", modifier = Modifier.padding(top = 24.dp))

        SocialIconsRow(modifier = Modifier.padding(8.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
fun SignupScreenPreview() {
    SignupScreen()
}
