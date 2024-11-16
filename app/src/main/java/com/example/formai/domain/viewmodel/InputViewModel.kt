package com.example.formai.domain.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor (): ViewModel() {

    private var inputType = mutableStateOf<InputType>(InputType.REALTIME)
    private var numRepetitions = mutableStateOf("")
    private var showSelectFileButton = mutableStateOf(false)
    private var exerciseType = mutableStateOf(ExerciseType.SQUAT)

    fun setInputType(inputType: InputType) {
        this.inputType.value = inputType
        if(inputType == InputType.PRERECORDED) {
            this.showSelectFileButton.value = true
        } else {
            this.showSelectFileButton.value = false
        }
    }

    fun getInputType(): InputType {
        return this.inputType.value
    }

    fun setNumRepetitions(reps: String) {
        if (reps.isDigitsOnly() || reps.isEmpty()) {
            this.numRepetitions.value = reps
        }
    }

    fun getNumRepetitions(): String {
        return this.numRepetitions.value
    }

    fun getShowFileSelectButton(): Boolean {
        return this.showSelectFileButton.value
    }

    fun setExerciseType(exercise: ExerciseType) {
        this.exerciseType.value = exercise
    }

    fun getExerciseType(): ExerciseType {
        return this.exerciseType.value
    }
}

enum class InputType {
    PRERECORDED,
    REALTIME
}

enum class ExerciseType {
    SQUAT,
    KNEEFLEXION
}