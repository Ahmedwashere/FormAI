package com.example.formai.ui.screens.results

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.formai.R
import com.example.formai.domain.viewmodel.ExerciseType
import com.example.formai.domain.viewmodel.InputViewModel
import com.example.formai.domain.viewmodel.WorkoutResultViewModel
import com.example.formai.navigation.Route
import com.example.formai.ui.screens.AppButton
import java.util.Locale

@Composable
fun ResultsScreen(
    navRoutes: (Route) -> Unit,
    inputViewModel: InputViewModel = hiltViewModel(),
    workoutViewModel: WorkoutResultViewModel = hiltViewModel()
) {

    /**
     * TODO: Make sure to clear the WorkoutResultViewModel when Start New Set is clicked.
     * TODO: And clear BOTH VIEW MODELS when End Session or Ask AI Trainer is clicked.
     */

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        // Text
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        )
        Text(
            "Workout Complete",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        val heresHowYouDidString = if (inputViewModel.getExerciseType() == ExerciseType.SQUAT)
            "Here's how you did on your Squats." else "Here's how you did on your Knee Curls."

        Text(
            text = heresHowYouDidString,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 30.dp),
            color = Color(0xFF999999),
        )

        // Circular Figure

        val completion =
            if (workoutViewModel.getSquatRepetitions() >= inputViewModel.getNumRepetitions()
                    .toInt()
            )
                1.0 else (workoutViewModel.getSquatRepetitions() / inputViewModel.getNumRepetitions()
                .toDouble())

        CircularProgressBarWithScore(completion = completion)

        val repsCompletedString = if (inputViewModel.getExerciseType() == ExerciseType.SQUAT)
            "${workoutViewModel.getSquatRepetitions()} Squats out of ${inputViewModel.getNumRepetitions()} in 30s"
        else "${workoutViewModel.getSquatRepetitions()} Knee Curls out of ${inputViewModel.getNumRepetitions()} in 30s"

        Text(
            text = repsCompletedString,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 30.dp),
            color = Color.Black,
        )
        // Form Breakdown and Tips For Improvement
        if (inputViewModel.getExerciseType() == ExerciseType.SQUAT) {
            Text(
                text = "Form Breakdown:",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 20.dp, bottom = 15.dp),
                color = Color.Black,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(
                        start = 20.dp, end = 30.dp, top = 0.dp, bottom = 5.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Depth",
                    color = Color(0xFF555555),
                    fontSize = 18.sp
                )

                val depth =
                    if (workoutViewModel.getNeedsImprovement()) (100 / workoutViewModel.angleForNeedsImprovement.doubleValue) * 100 else 100
                Text(
                    "${depth.toInt()}%",
                    color = Color(0xFF555555),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(
                        start = 20.dp, end = 30.dp, top = 0.dp, bottom = 5.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Knee Alignment",
                    color = Color(0xFF555555),
                    fontSize = 18.sp
                )

                val kneeAlignment = if (workoutViewModel.getIsKneeCollapsed()) 75 else 100
                Text(
                    "${kneeAlignment}%",
                    color = Color(0xFF555555),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
            }

            if (workoutViewModel.getIsKneeCollapsed() || workoutViewModel.getNeedsImprovement()) {
                Text(
                    text = "Tips For Improvement:",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 10.dp, bottom = 15.dp),
                    color = Color.Black,
                )

                if (workoutViewModel.getIsKneeCollapsed()) {
                    TipRow(text = "Don't collapse knees inward")
                    TipRow(text = "Keep knees over toes while squatting")
                }

                if (workoutViewModel.getNeedsImprovement()) {
                    TipRow(text = "Get more depth on the squat")
                }
            }

        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        // Buttons
        AppButton(
            contentColor = Color.Black,
            containerColor = Color.Transparent,
            onClickAction = { navRoutes(Route.Chatbot) },
            shape = RoundedCornerShape(5.dp),
            borderWidth = 0.3.dp,
            borderColor = Color(0xFF999999),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 5.dp),
            modifier = Modifier
                .width(345.dp)
                .height(45.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ai_icon),
                    contentDescription = "AI chatbot Icon",
                    modifier = Modifier
                        .size(40.dp, 32.dp)
                        .padding(end = 15.dp)
                )

                Text(
                    "Ask AI Trainer For Tips",
                    color = Color(0xFF555555),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light
                )
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
        )

        Row(
            modifier = Modifier
                .width(345.dp)
                .height(50.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AppButton(
                contentColor = Color.White, containerColor = Color.Black,
                onClickAction = {
                    workoutViewModel.clearFields()
                    navRoutes(Route.Wall)
                },
                modifier = Modifier
                    .fillMaxHeight()
                    .width(154.dp),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    "Start New Set",
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp
                )
            }

            AppButton(
                contentColor = Color.White, containerColor = Color(0xFFFF4949),
                onClickAction = {
                    workoutViewModel.clearFields()
                    inputViewModel.clearAll()
                    navRoutes(Route.Main)
                },
                modifier = Modifier
                    .fillMaxHeight()
                    .width(154.dp),
                shape = RoundedCornerShape(5.dp),
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 5.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.end_session_icon),
                    contentDescription = "AI chatbot Icon",
                    modifier = Modifier
                        .size(30.dp, 25.dp)
                        .padding(end = 10.dp)
                )

                Text(
                    "End Session",
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun CircularProgressBarWithScore(completion: Double) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
    ) {
        CircularProgressIndicator(
            progress = { return@CircularProgressIndicator completion.toFloat() },
            modifier = Modifier
                .size(160.dp)
                .align(Alignment.Center),
            strokeWidth = 20.dp,
            strokeCap = StrokeCap.Butt,
            trackColor = Color(0xFF777777),
            color = Color.Black
        )

        Text(
            String.format(Locale.ENGLISH, "%.0f", completion * 100.0) + "%",
            modifier = Modifier.align(Alignment.Center),
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
    }
}

@Composable
fun TipRow(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(35.dp)
            .padding(start = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.tip_icon),
            contentDescription = "Tips Icon",
            modifier = Modifier
                .size(35.dp)
                .padding(end = 15.dp)
        )

        Text(
            text,
            color = Color(0xFF555555),
            fontSize = 18.sp
        )
    }
}

@Preview
@Composable
fun ResultsScreenPreview() {
    val workoutViewModel = WorkoutResultViewModel()
    workoutViewModel.setKneeCollapsed(true)
    workoutViewModel.setNeedImprovement(true)
    ResultsScreen(navRoutes = {}, workoutViewModel = workoutViewModel)
}

@Preview
@Composable
fun CircularProgressBarWithScorePreview() {
    CircularProgressBarWithScore(completion = 0.90)
}

@Preview
@Composable
fun TipRowPreview() {
    TipRow(text = "Don't Collapse Knees Inward")
}