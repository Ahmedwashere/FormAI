package com.example.formai.domain.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(): ViewModel() {

    val generativeModel : GenerativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash-001",
        // IF YOU CLONE THIS REPOSITORY REPLACE WITH YOUR OWN API KEY
        apiKey = Constants.geminiApiKey
    )

    fun sendMessage(question: String) {
        viewModelScope.launch {
            val chat = generativeModel.startChat()
            val response = chat.sendMessage(question)

            Log.i("Response from Gemini", response.text.toString())
        }
    }
}