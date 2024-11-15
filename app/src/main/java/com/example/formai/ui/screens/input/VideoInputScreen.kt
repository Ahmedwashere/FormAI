package com.example.formai.ui.screens.input

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.formai.R
import com.example.formai.domain.viewmodel.InputViewModel
import com.example.formai.navigation.Route
import com.example.formai.ui.screens.AppButton
import com.example.formai.ui.screens.BackButtonExplore

@Composable
fun VideoInputScreen(
    navigateTo: (Route) -> Unit,
    inputViewModel: InputViewModel = hiltViewModel()
) {

    BackButtonExplore(
        modifier = Modifier
            .size(32.dp, 37.dp)
            .fillMaxWidth(),
        navigateTo,
        Route.Main
    )

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Card(
            elevation = CardDefaults.cardElevation(15.dp),
            modifier = Modifier.size(350.dp),
            colors = CardDefaults
                .cardColors(containerColor = Color.White)
        ) {

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(25.dp)
            )
            Text(
                "Select Video Input",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
            )

            // FIRST ROW OF BUTTONS
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    modifier = Modifier.size(height = 50.dp, width = 140.dp),
                    onClick = {
                        /**
                        TODO: Update the ViewModel if the user
                        selects this as their input */
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonColors(
                        contentColor = Color.Black,
                        containerColor = Color(0xFFD9D9D9),
                        disabledContainerColor = Color(0xFFD9D9D9),
                        disabledContentColor = Color.Black,
                    ),
                    contentPadding = PaddingValues(16.dp, 8.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.file_icon),
                            contentDescription = "File Icon",
                            modifier = Modifier.size(18.dp)
                        )

                        Text(
                            "Recording",
                            modifier = Modifier.padding(start = 4.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }

                Button(
                    modifier = Modifier.size(height = 50.dp, width = 140.dp),
                    onClick = {
                        /**
                        TODO: Update the ViewModel if the user
                        selects this as their input */
                    },
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonColors(
                        contentColor = Color.Black,
                        containerColor = Color(0xFFD9D9D9),
                        disabledContainerColor = Color(0xFFD9D9D9),
                        disabledContentColor = Color.Black,
                    ),
                    contentPadding = PaddingValues(16.dp, 8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.camera_icon),
                            contentDescription = "Camera Icon",
                            modifier = Modifier.size(20.dp)
                        )

                        Text(
                            "Real-Time",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                }
            }
            // Number of repetitions from the user
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(20.dp).fillMaxWidth())
                Text(
                    "Number Of Repetitions",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 24.dp, bottom = 8.dp)
                )

                // The value is the value
                RepetitionsTextBox(
                    value = inputViewModel.getNumRepetitions(),
                    onValueChange = { value ->
                        if (!value.trim().isDigitsOnly()) {
                            inputViewModel.setNumRepetitions(value)
                        }
                    },
                    modifier = Modifier
                        .size(328.dp, 48.dp)
                        .align(Alignment.CenterHorizontally)
                        .padding(start = 14.dp, end = 14.dp)
                )

                // Submit Button
                Spacer(modifier = Modifier.fillMaxWidth().height(30.dp))
                AppButton(
                    modifier = Modifier
                        .size(height = 50.dp, width = 130.dp)
                        .align(Alignment.CenterHorizontally),
                    onClickAction = {
                        /**
                        TODO: Navigate to the
                         */
                    },
                    shape = RoundedCornerShape(5.dp),
                    contentColor = Color.White,
                    containerColor = Color.Black,
                    contentPadding = PaddingValues(24.dp, 8.dp)
                ) {
                    Text("Submit")
                }
            }
        }
    }
}

@Composable
fun RepetitionsTextBox(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        shape = RoundedCornerShape(5),
    )
}

@Preview(
    showSystemUi = true,
    showBackground = true,
)
@Composable
fun VideoInputScreenPreview() {
    VideoInputScreen(navigateTo = {})
}