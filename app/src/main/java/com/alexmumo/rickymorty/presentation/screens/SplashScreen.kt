package com.alexmumo.rickymorty.presentation.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.alexmumo.rickymorty.presentation.ui.navigation.NavigationItem
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(key1 = true) {
        delay(3000L)
        navController.navigate(NavigationItem.Home.route)
    }
    Text(text = "RickyMorty")
}

@Preview
@Composable
fun SplashScreenPreview() {
}
