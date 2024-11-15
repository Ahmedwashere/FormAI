package com.example.formai.domain.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor (): ViewModel() {

    private var inputType = mutableStateOf<InputType>(InputType.REALTIME)
    private var numRepetitions = mutableStateOf("")
    private var showSelectFileButton = mutableStateOf(false)

    fun setInputType(inputType: InputType) {
        this.inputType.value = inputType
        if(inputType == InputType.PRERECORDED) {
            this.showSelectFileButton.value = true
        }
    }

    fun getInputType(): InputType {
        return this.inputType.value
    }

    fun setNumRepetitions(reps: String) {
        this.numRepetitions.value = reps
    }

    fun getNumRepetitions(): String {
        return this.numRepetitions.value
    }

    fun getShowFileSelectButton(): Boolean {
        return this.showSelectFileButton.value
    }
}

enum class InputType {
    PRERECORDED,
    REALTIME
}