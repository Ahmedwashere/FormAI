package com.example.formai.ui.screens.explore

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
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
import com.example.formai.R
import com.example.formai.navigation.Route
import com.example.formai.ui.screens.AppButton
import com.example.formai.ui.screens.BackButtonExplore

@Composable
fun ExploreScreen(
    navigateTo: (Route) -> Unit
) {
    Box(
        modifier = Modifier
            .verticalScroll(enabled = true, state = rememberScrollState())
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            /** Backbutton and Text at the top */
            Row() {
                BackButtonExplore(
                    modifier = Modifier
                        .size(32.dp, 37.dp)
                        .fillMaxWidth(),
                    navigateTo,
                    Route.Welcome
                )

                Text(
                    "Your Winter Arc \nStarts Here",
                    fontSize = 28.sp,
                    modifier = Modifier.padding(start = 8.dp, top = 16.dp)
                )
            }

            /** DAILY CHALLENGE PORTION */
            Text(
                "Daily Challenge",
                modifier = Modifier.padding(top = 16.dp, start = 24.dp, bottom = 8.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )

            Card(
                modifier = Modifier
                    .size(350.dp, 350.dp)
                    .align(Alignment.CenterHorizontally),
                border = BorderStroke(0.5.dp, color = Color.Black),
                shape = RoundedCornerShape(20.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xFF278ABB))
                ) {
                    Column() {
                        Spacer(modifier = Modifier.size(30.dp))
                        Image(
                            painter = painterResource(id = R.drawable.lady_squatting_image),
                            contentDescription = "Lady squatting with a barbell.",
                            modifier = Modifier.size(270.dp, 300.dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 200.dp)
                    ) {
                        Spacer(modifier = Modifier.size(180.dp).fillMaxWidth())
                        Text(
                            "Leg \nExercise",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            modifier = Modifier.padding(start = 28.dp),
                        )

                        Spacer(modifier = Modifier.size(30.dp))

                        AppButton(
                            contentColor = Color.White,
                            containerColor = Color.Black,
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(35.dp)
                                .width(120.dp)
                                .padding(start = 16.dp, end = 16.dp),
                            onClickAction = { /** TODO: Add Navigation FOR SQUAT WORKOUT here! */ },
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(id = R.drawable.start_icon),
                                    contentDescription = "Start Icon",
                                    modifier = Modifier.size(30.dp)
                                )

                                Text("Squat",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White)
                            }
                        }
                    }


                }
            }

            Spacer(Modifier.size(16.dp))

            /** DAILY REHAB EXERCISE */
            Text(
                "Daily Rehab Exercise",
                modifier = Modifier.padding(top = 16.dp, start = 24.dp, bottom = 8.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )

            Card(
                modifier = Modifier
                    .size(350.dp, 350.dp)
                    .align(Alignment.CenterHorizontally),
                border = BorderStroke(0.5.dp, color = Color.Black),
                shape = RoundedCornerShape(20.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color(0xFF278ABB))
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = R.drawable.knee_flexion_exercise),
                            contentDescription = "Lady doing knee flexion exercise.",
                            modifier = Modifier.size(270.dp, 300.dp)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 200.dp)
                    ) {
                        Spacer(modifier = Modifier.size(180.dp).fillMaxWidth())
                        Text(
                            "Knee \nFlexion",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            modifier = Modifier.padding(start = 28.dp),
                        )

                        Spacer(modifier = Modifier.size(30.dp))

                        AppButton(
                            contentColor = Color.White,
                            containerColor = Color.Black,
                            shape = RoundedCornerShape(50.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(35.dp)
                                .width(120.dp)
                                .padding(start = 16.dp, end = 8.dp),
                            onClickAction = { /** TODO: Add Navigation to KNEE WORKOUT here! */ },
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(id = R.drawable.start_icon),
                                    contentDescription = "Start Icon",
                                    modifier = Modifier.size(30.dp)
                                )

                                Text("Flexion",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White)
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ExploreScreenPreview() {
    ExploreScreen() {}
}
