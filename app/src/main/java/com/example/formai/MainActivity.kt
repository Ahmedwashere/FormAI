package com.example.formai

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import com.example.formai.domain.viewmodel.PoseLandmarkViewModel
import com.example.formai.domain.viewmodel.WorkoutResultViewModel
import com.example.formai.navigation.navigation
import com.example.formai.ui.screens.input.VideoInputScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val cameraPermissionRequest =
            registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
                if (isGranted) {
                    Log.d("CAMERA", "onCreate: CAMERA PERMISSION GRANTED")
                    setContent()
                } else {
                    Log.d("CAMERA", "onCreate: CAMERA PERMISSION DENIED")
                    throw IllegalStateException("User denied camera permission.")
                }
            }

        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) -> {
                Log.d("PACKAGE MANAGER", "Camera permission already granted")
                setContent()
            }

            else -> {
                Log.d("PACKAGE MANAGER", "Requesting camera permission")
                cameraPermissionRequest.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun setContent() {
        setContent {
            navigation()
        }
    }
}
