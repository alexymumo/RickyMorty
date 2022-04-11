package com.alexmumo.rickymorty.presentation.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.alexmumo.rickymorty.presentation.ui.navigation.NavigationItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@Composable
fun SplashScreen(
    navController: NavController
) {
    val scale = remember {
        Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2.5f)
    }
    LaunchedEffect(key1 = true) {
        withContext(Dispatchers.Main) {
            scale.animateTo(
                targetValue = 1.5f,
                animationSpec = tween(
                    durationMillis = 700,
                    easing = {
                        overshootInterpolator.getInterpolation(it)
                    }
                )
            )
        }
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
            textAlign = TextAlign.Center,
            text = "RickyMorty",
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 80.sp,
        )
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
}
