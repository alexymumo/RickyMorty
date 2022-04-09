package com.alexmumo.rickymorty.presentation.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alexmumo.rickymorty.presentation.screens.EpisodeScreen
import com.alexmumo.rickymorty.presentation.screens.HomeScreen
import com.alexmumo.rickymorty.presentation.screens.SearchScreen
import com.alexmumo.rickymorty.presentation.screens.SettingScreen

@ExperimentalFoundationApi
@Composable
fun Navigation(navHostController: NavHostController) {

    NavHost(navHostController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }
        composable(NavigationItem.Search.route) {
            SearchScreen()
        }
        composable(NavigationItem.Settings.route) {
            SettingScreen()
        }
        composable(NavigationItem.Episodes.route) {
            EpisodeScreen()
        }
    }
}
