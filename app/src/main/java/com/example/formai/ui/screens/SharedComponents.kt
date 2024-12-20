package com.example.formai.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.formai.R
import com.example.formai.domain.viewmodel.AuthViewModel
import com.example.formai.navigation.Route
import com.example.formai.ui.theme.latoFont

/**
 * This file will store shared composables/components which are used across more than one screen.
 */
@Composable
fun SocialIconsRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.then(
            Modifier
                .fillMaxWidth()
                .height(65.dp)
        ),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            modifier = Modifier
                .size(56.dp, 48.dp)
                .align(Alignment.CenterVertically),
            onClick = { /** TODO Add google sign in / sign up */ },
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonColors(
                containerColor = Color(0xFFFEF7FF),
                contentColor = Color.Transparent,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color(0xFFFEF7FF)
            ),
            border = BorderStroke(0.5.dp, Color.Black)
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google Icon",
                modifier = Modifier.size(30.dp)
            )
        }

        Button(
            modifier = Modifier
                .size(56.dp, 48.dp)
                .align(Alignment.CenterVertically),
            onClick = { /** TODO Add google sign in / sign up */ },
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonColors(
                containerColor = Color(0xFFFEF7FF),
                contentColor = Color.Transparent,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color(0xFFFEF7FF)
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "Google Icon",
                modifier = Modifier.size(24.dp)
            )
        }

        Button(
            modifier = Modifier
                .size(56.dp, 48.dp)
                .align(Alignment.CenterVertically),
            onClick = { /** TODO Add google sign in / sign up */ },
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonColors(
                containerColor = Color(0xFFFEF7FF),
                contentColor = Color.Transparent,
                disabledContentColor = Color.Transparent,
                disabledContainerColor = Color(0xFFFEF7FF)
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.twitter_black),
                contentDescription = "Google Icon",
                modifier = Modifier.size(24.dp),
            )
        }
    }
}

@Preview
@Composable
fun SocialIconsPreview() {
    SocialIconsRow()
}

/**
 * Composable used within both the Login and signup page for the row with box and
 * "Or Log In" OR "Or Sign Up"
 */
@Composable
fun OrWithSocialsRow(text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .then(
                Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            ),
        Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(95.dp)
                .height(2.dp)
                .background(Color(0xFFAAAAAA))
        )

        Text(
            text = text,
            fontSize = 16.sp,
            fontFamily = latoFont,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 10.dp)
        )

        Box(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .width(95.dp)
                .height(2.dp)
                .background(Color(0xFFAAAAAA))
        )
    }
}


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
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
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
        contentPadding = contentPadding,
        border = BorderStroke(borderWidth, borderColor),
        shape = shape,
    ) {
        content()
    }
}

@Composable
fun CircularAppLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.app_logo_no_background),
        contentDescription = "Circle that's grey with App logo within.",
        // modifiers have a .then function for extra user input
        modifier = modifier.then(
            Modifier
                .size(153.dp)
                .clip(CircleShape)
                .background(Color(0xFF333333))
                .padding(16.dp)
        ),
    )
}

/**
 * smaller when I apply a padding to the box which is weird.
 *
 * For example after setting a size, if I give
 * a padding to the box, then the size of the box decreases which is a problem
 * I noticed.
 *
 */
@Composable
fun BackButtonLogInOrSignUp(
    modifier: Modifier = Modifier,
    navigateTo: (Route) -> Unit,
    route: Route,
    authViewModel: AuthViewModel = hiltViewModel()
) {
    Button(
        modifier = Modifier.padding(start = 4.dp, top = 16.dp),
        onClick = {
            authViewModel.clearFields()
            navigateTo(route)
        },
        contentPadding = PaddingValues(0.dp),
        colors = ButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Transparent,
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        )
    ) {
        Surface(modifier = modifier) {
            Image(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "Back arrow for navigation",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

/**
 * Back button exclusively for the explore page.
 */
@Composable
fun BackButtonExplore(
    modifier: Modifier = Modifier,
    navigateTo: (Route) -> Unit,
    route: Route,
) {
    Button(
        modifier = Modifier.padding(start = 4.dp, top = 16.dp),
        onClick = {
            navigateTo(route)
        },
        contentPadding = PaddingValues(0.dp),
        colors = ButtonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Transparent,
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        )
    ) {
        Surface(modifier = modifier) {
            Image(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "Back arrow for navigation",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CircularAppLogoPreview() {
    CircularAppLogo()
}

@Preview()
@Composable
fun BackButtonPreview() {
    BackButtonLogInOrSignUp(
        modifier = Modifier
            .size(26.dp, 30.dp)
            .fillMaxSize(),
        {},
        Route.Welcome
    )
}