package com.example.formai.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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