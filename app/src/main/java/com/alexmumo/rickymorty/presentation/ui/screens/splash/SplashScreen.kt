package com.alexmumo.rickymorty.presentation.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alexmumo.rickymorty.R
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
        Modifier.fillMaxWidth().background(
            color = MaterialTheme.colors.surface
        ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_home),
            modifier = Modifier.height(50.dp),
            contentDescription = "splash"
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
}
