package com.example.formai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.formai.ui.screens.welcome.WelcomeScreen
import com.example.formai.ui.theme.FormAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FormAITheme {
                WelcomeScreen()
            }
        }
    }
}
