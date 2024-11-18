package com.example.formai.ui.screens.chatbot

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.formai.domain.viewmodel.ChatViewModel
import com.example.formai.navigation.Route

@Composable
fun ChatBotScreen(
    navRoute: (Route) -> Unit,
    viewModel: ChatViewModel = hiltViewModel()
) {

    Column {
        AppHeader()
        MessageInput(onMessageSend = {
            viewModel.sendMessage(it)
        })
    }
}

@Composable
fun AppHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            "AI Chatbot And Form Coach",
            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun MessageInput(onMessageSend: (String) -> Unit) {

    var message by remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = message,
            onValueChange = {
                message = it
            },
            modifier = Modifier.weight(1f)
        )

        IconButton(onClick = {
            onMessageSend
            message = ""
        }) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.Send,
                contentDescription = "Send"
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ChatbotScreenPreview() {
    ChatBotScreen(viewModel = ChatViewModel(), navRoute = {})
}