package com.alexmumo.rickymorty.presentation.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexmumo.rickymorty.presentation.screens.*

// ktlint-disable no-wildcard-imports

@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Splash.route) {
        composable(route = NavigationItem.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = NavigationItem.Search.route) {
            SearchScreen(navController = navController)
        }
        composable(route = NavigationItem.Settings.route) {
            SettingScreen(navController = navController)
        }
        composable(route = NavigationItem.Episodes.route) {
            EpisodeScreen(navController = navController)
        }
    }
}
