package com.alexmumo.rickymorty.presentation.ui.navigation

import com.alexmumo.rickymorty.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_launcher_background, "Home")
    object Episodes : NavigationItem("episodes", R.drawable.ic_launcher_background, "Episodes")
    object Settings : NavigationItem("settings", R.drawable.ic_launcher_background, "Settings")
}


