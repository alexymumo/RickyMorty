package com.alexmumo.rickymorty.presentation.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alexmumo.rickymorty.presentation.screens.*
import com.alexmumo.rickymorty.presentation.ui.screens.settings.SettingScreen
import com.alexmumo.rickymorty.presentation.ui.screens.splash.SplashScreen

@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Splash.route) {
        composable(route = NavigationItem.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = NavigationItem.Settings.route) {
            SettingScreen(navController = navController)
        }
        composable(route = NavigationItem.Episodes.route) {
            EpisodeScreen(navController = navController)
        }
        composable(route = NavigationItem.Search.route) {
            SearchScreen(navController = navController)
        }
        composable(
            route = NavigationItem.Details.route,
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) {
            val id = it.arguments?.getInt("id")
            if (id != null) {
                DetailScreen(navController = navController, id = id)
            }
        }
    }
}
