package com.example.formai.ui.screens.input

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.formai.R
import com.example.formai.navigation.Route
import com.example.formai.ui.screens.BackButtonExplore

@Composable
fun SetPhoneAgainstWallScreen(
    navigateTo: (Route) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        BackButtonExplore(
            modifier = Modifier
                .size(32.dp, 37.dp)
                .fillMaxWidth(),
            navigateTo,
            Route.Main
        )

        Text("Please Place Your\nPhone On The Ground\nTilted Towards You",
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(30.dp).fillMaxWidth())

        Image(
            painter = painterResource(id = R.drawable.phone_titled_against_wall),
            contentDescription = "Phone against a wall",
            modifier = Modifier.size(282.dp, 390.dp).clip(RoundedCornerShape(10.dp))
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(30.dp).fillMaxWidth())

        Text("Please Select An Area\nWith Good Lighting",
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.fillMaxWidth().height(30.dp))
        
        Button(
            onClick = { /*TODO Navigate to the Workout Screen */ },
            modifier = Modifier.size(width = 320.dp, height = 67.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonColors(
                contentColor = Color.Black,
                containerColor = Color(0xFFF0FD3D),
                disabledContainerColor = Color(0xFFF0FD3D),
                disabledContentColor = Color.Black,
            ),
        ) {
            Text("Begin Workout",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold)
        }
        
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun SetPhoneAgainstWallPreview() {
    SetPhoneAgainstWallScreen {}
}