package com.example.formai.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.formai.navigation.Route

@Composable
fun ChatBotScreen(
    navRoute: (Route) -> Unit
) {
    Text("ITS WORKING",
        fontSize =  70.sp)
}