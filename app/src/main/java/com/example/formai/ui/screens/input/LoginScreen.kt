package com.example.formai.ui.screens.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formai.ui.screens.welcome.WelcomePageButton
import com.example.formai.ui.theme.latoFont

// This page will hold the UI for logging in

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
    Column {

    }
}

/*
 Welcome Button Documentation:

    modifier: Modifier = Modifier,
    contentColor: Color,
    containerColor: Color,
    shape: Shape = RoundedCornerShape(30.dp),v
    onClickNavigationRequest: () -> Unit,
    borderWidth: Dp = 0.dp,
    borderColor: Color = Color.White,
    content: @Composable () -> Unit,
 */

@Preview(
    showBackground = true,
)
@Composable
fun LoginButtonPreview() {
    WelcomePageButton(
        modifier = Modifier.width(314.dp).height(56.dp).padding(4.dp),
        contentColor = Color.White,
        containerColor = Color(0xFF014863),
        shape = RoundedCornerShape(15.dp),
        onClickNavigationRequest = {},
        content = {
            Text(text = "Login", fontFamily = latoFont)
        })
}

