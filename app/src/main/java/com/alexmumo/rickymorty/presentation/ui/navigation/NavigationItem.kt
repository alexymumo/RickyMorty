package com.alexmumo.rickymorty.presentation.ui.navigation

import com.alexmumo.rickymorty.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object Episodes : NavigationItem("episodes", R.drawable.ic_episode, "Episodes")
    object Settings : NavigationItem("settings", R.drawable.ic_settings, "Settings")
}
