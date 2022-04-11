package com.alexmumo.rickymorty.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexmumo.rickymorty.presentation.ui.navigation.NavigationItem
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(

    navController: NavController
) {
    LaunchedEffect(key1 = true) {
        delay(2000L)
        navController.navigate(NavigationItem.Home.route)
    }
    Box(
        Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.surface),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "RickyMorty",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 80.sp
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
}
