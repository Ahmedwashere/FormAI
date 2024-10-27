package com.example.formai.ui.screens.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.formai.R
import com.example.formai.ui.theme.interFont


// UI for the WelcomeScreen of the App
@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF444444))
    ) {

        Column {
            Image(
                painter = painterResource(id = R.drawable.app_logo_no_background),
                contentDescription = "App Logo of a stick figure running",
                modifier = Modifier
                    .size(155.dp, 143.dp)
                    .padding(start = 16.dp, top = 16.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Box {
                Image(
                    painter = painterResource(id = R.drawable.welcome_screen_guy_running),
                    contentDescription = "Man Sprinting. No Background.",
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )

                Text(
                    text = "Your Personal Fitness Buddy. Good Form Made Easy.",
                    fontFamily = interFont,
                    fontSize = 40.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 16.dp, end = 80.dp, top = 270.dp)
                        .wrapContentSize(),
                    lineHeight = 1.2.em
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()
            ) {
                WelcomePageButton(
                    modifier = Modifier
                        .width(175.dp)
                        .height(74.dp)
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    contentColor = Color.Black,
                    containerColor = Color(0xFFF0FD3D),
                    shape = RoundedCornerShape(30.dp),
                    onClickNavigationRequest = { /* TODO */ },
                    content = {
                        Text(
                            "Log In",
                            fontSize = 20.sp,
                            fontFamily = interFont,
                        )
                    },
                )

                WelcomePageButton(
                    modifier = Modifier
                        .width(175.dp)
                        .height(74.dp)
                        .padding(top = 8.dp)
                        .fillMaxWidth(),
                    contentColor = Color.White,
                    containerColor = Color.Transparent,
                    shape = RoundedCornerShape(30.dp),
                    onClickNavigationRequest = {/* TODO */ },
                    content = {
                        Text(
                            text = "Sign Up",
                            fontSize = 20.sp,
                            fontFamily = interFont,
                        )
                    },
                    borderWidth = 1.5.dp
                )
            }
        }
    }
}

// Composable for buttons used on the welcome page
@Composable
fun WelcomePageButton(
    modifier: Modifier = Modifier,
    contentColor: Color,
    containerColor: Color,
    shape: Shape = RoundedCornerShape(30.dp),
    onClickNavigationRequest: () -> Unit,
    borderWidth: Dp = 0.dp,
    borderColor: Color = Color.White,
    content: @Composable () -> Unit,
) {
    Button(
        onClick = onClickNavigationRequest,
        modifier = modifier,
        colors = ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContentColor = contentColor,
            disabledContainerColor = containerColor
        ),
        border = BorderStroke(borderWidth, borderColor),
        shape = shape,
    ) {
        content()
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}

@Preview(showBackground = true)
@Composable
fun LoginButtonPreview() {
    WelcomePageButton(
        modifier = Modifier.width(160.dp),
        contentColor = Color.Black,
        containerColor = Color(0xFFF0FD3D),
        shape = RoundedCornerShape(30.dp),
        onClickNavigationRequest = {},
        content = { Text(text = "Log In") },
    )
}

@Preview(
    showBackground = true, backgroundColor = 0xFF444444
)
@Composable
fun SignUpButtonPreview() {
    WelcomePageButton(
        modifier = Modifier.width(160.dp),
        contentColor = Color.White,
        containerColor = Color.Transparent,
        shape = RoundedCornerShape(30.dp),
        onClickNavigationRequest = {},
        content = { Text(text = "Log In") },
    )
}