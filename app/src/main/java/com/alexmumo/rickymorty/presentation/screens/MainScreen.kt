package com.alexmumo.rickymorty.presentation.screens

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.alexmumo.rickymorty.presentation.home.character.components.BottomBar
import com.alexmumo.rickymorty.presentation.ui.navigation.Navigation
import com.alexmumo.rickymorty.presentation.ui.navigation.TopBar
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun MainScreen() {
    val navController = rememberAnimatedNavController()

    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar() }
    ) {
        Navigation(navController = navController)
    }
}
