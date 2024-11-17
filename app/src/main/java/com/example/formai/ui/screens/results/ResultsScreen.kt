package com.example.formai.ui.screens.results

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.formai.domain.viewmodel.InputViewModel
import com.example.formai.navigation.Route

@Composable
fun ResultsScreen(
    navRoutes: (Route) -> Unit,
    inputViewModel: InputViewModel = hiltViewModel()
) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("WE REACHED THE RESULTS PAGE! With a repetition count of ${
            inputViewModel.getNumRepetitions()
        } .", fontSize = 40.sp)
    }
}