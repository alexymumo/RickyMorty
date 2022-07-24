package com.alexmumo.rickymorty.presentation.ui.screens.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import com.alexmumo.rickymorty.presentation.ui.navigation.BottomNavigationBar
import com.alexmumo.rickymorty.presentation.ui.navigation.Navigation
import com.alexmumo.rickymorty.presentation.ui.navigation.NavigationItem
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun MainScreen() {
    val navController = rememberAnimatedNavController()

    val topDestinations = listOf(
        NavigationItem.Home,
        NavigationItem.Settings,
        NavigationItem.Search
    )
    val isTopDestination = navController.currentBackStackEntryAsState().value?.destination?.route in topDestinations.map { it.route }

    val backStackEntryState = navController.currentBackStackEntryAsState()
    Scaffold(
        bottomBar = {
            if (isTopDestination) {
                BottomNavigationBar(
                    navController = navController,
                    backStackEntryState = backStackEntryState,
                    bottomNavItems = topDestinations
                )
            }
        }
    ) {
        Navigation(navController = navController)
    }
}

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}
