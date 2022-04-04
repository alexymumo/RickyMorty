package com.alexmumo.rickymorty.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.alexmumo.rickymorty.R

@Composable
fun SplashScreen(
    navController: NavController
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "rickymorty"
        )
    }
}

/*
1//09BSp73GBfIVvCgYIARAAGAkSNwF-L9IrwJAl9YGR-mNJtAgidygbyzIRdduhcJwv7pH7nnZZI425LvMrKLn6GymCFds_1FGumjY

 */

