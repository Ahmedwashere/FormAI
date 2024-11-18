package com.example.formai.domain.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkoutResultViewModel @Inject constructor() : ViewModel() {

    val _squat_repetitions = mutableStateOf(0)
    val _deep_squat_frames_count = mutableStateOf(0)
    val _need_improvement_squat_frame_count = mutableStateOf(0)
    val _collapse_knee_frame_count = mutableStateOf(0)
    var _knee_collapsed = false
    var _currPosition = SquatQuality.STANDING
    var _needs_improvement = false
    val angleForNeedsImprovement = mutableDoubleStateOf(100.0)
    var specified_repetitions: Int? = null
    /** TODO: Add a variable to track the users deepest bad squat if needs improvement is true */
    /** TODO: Add a way to somehow track a knee alignment score. */

    // Getters
    fun getSquatRepetitions(): Int = _squat_repetitions.value
    fun getDeepSquatFramesCount(): Int = _deep_squat_frames_count.value
    fun getNeedImprovementSquatFramesCount(): Int = _need_improvement_squat_frame_count.value
    fun getCollapseKneeFrameCount(): Int = _collapse_knee_frame_count.value

    // TO BE USED FOR WORKOUT RESULTS
    fun getIsKneeCollapsed(): Boolean = _knee_collapsed
    fun getNeedsImprovement(): Boolean = _needs_improvement
    // TO BE USED FOR WORKOUT RESULTS

    fun getCurrentPosition(): SquatQuality = _currPosition

    // Setters
    fun setSquatRepetitions(value: Int) {
        _squat_repetitions.value = value
    }

    fun setDeepSquatFramesCount(value: Int) {
        _deep_squat_frames_count.value = value
    }

    fun setNeedImprovementSquatFramesCount(value: Int) {
        _need_improvement_squat_frame_count.value = value
    }

    fun setCollapseKneeFramesCount(value: Int) {
        _collapse_knee_frame_count.value = value
    }

    fun setKneeCollapsed(value: Boolean) {
        _knee_collapsed = value
    }

    fun setNeedImprovement(value: Boolean) {
        _needs_improvement = value
    }

    fun setCurrentPosition(value: Double) {
        if (value > 150.0) {
            _currPosition = SquatQuality.STANDING
        } else if (value < 150.0 && value > 120.0) {
            _currPosition = SquatQuality.NO_ZONE
        } else if (value < 120.0 && value > 100.0) {
            _currPosition = SquatQuality.NEEDS_IMPROVEMENT
        } else {
            _currPosition = SquatQuality.DEEP_SQUAT
        }
    }

    // State for the Timer

    // Timer states
    private val _isAnalysisActive = mutableStateOf(false)
    val isAnalysisActive: State<Boolean> get() = _isAnalysisActive

    private val _remainingTime = mutableIntStateOf(30) // 30 seconds countdown
    val remainingTime: State<Int> get() = _remainingTime

    fun startAnalysis() {
        _isAnalysisActive.value = true
    }

    fun stopAnalysis() {
        _isAnalysisActive.value = false
    }

    fun setRemainingTime(time: Int) {
        _remainingTime.intValue = time
    }

    //Reset the states when we start a new set.
    fun clearFields() {
        // Reset all mutable states and variables to their default values
        _squat_repetitions.value = 0
        _deep_squat_frames_count.value = 0
        _need_improvement_squat_frame_count.value = 0
        _collapse_knee_frame_count.value = 0
        _knee_collapsed = false
        _currPosition = SquatQuality.STANDING
        _needs_improvement = false
        angleForNeedsImprovement.value = 100.0
        specified_repetitions = null
        _isAnalysisActive.value = false
        _remainingTime.intValue = 30
    }


}

enum class SquatQuality {
    DEEP_SQUAT,
    NEEDS_IMPROVEMENT,
    NO_ZONE,
    STANDING,
}