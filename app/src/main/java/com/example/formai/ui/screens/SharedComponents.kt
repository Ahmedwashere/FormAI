package com.example.formai.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.formai.R

/**
 * This file will store shared composables/components which are used across more than one screen.
 */


// Composable for buttons used on the welcome page
@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    contentColor: Color,
    containerColor: Color,
    shape: Shape = RoundedCornerShape(30.dp),
    onClickAction: () -> Unit,
    borderWidth: Dp = 0.dp,
    borderColor: Color = Color.White,
    content: @Composable () -> Unit,
) {
    Button(
        onClick = onClickAction,
        modifier = modifier,
        colors = ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContentColor = contentColor,
            disabledContainerColor = containerColor
        ),
        border = BorderStroke(borderWidth, borderColor),
        shape = shape,
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun CircularAppLogoPreview() {
    Image(
        painter = painterResource(id = R.drawable.app_logo_no_background),
        contentDescription = "Circle that's grey with App logo within.",
        modifier = Modifier
            .size(153.dp)
            .clip(CircleShape)
            .background(Color(0xFF444444))
            .padding(24.dp),
    )
}