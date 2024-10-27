package com.example.formai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.formai.ui.theme.FormAITheme
import com.example.formai.ui.theme.interFont

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormAITheme {

            }
        }
    }
}

// UI for the WelcomeScreen of the App
@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF444444))
    ) {

        // Navigation Buttons
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()) {
            WelcomePageButton(
                modifier = Modifier
                    .width(175.dp)
                    .height(76.dp)
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp)
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
                    .height(76.dp)
                    .padding(end = 8.dp, top = 8.dp, bottom = 8.dp)
                    .fillMaxWidth(),
                contentColor = Color.White,
                containerColor = Color.Transparent,
                shape = RoundedCornerShape(30.dp),
                onClickNavigationRequest = {/* TODO */},
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
