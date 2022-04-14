package com.alexmumo.rickymorty.presentation.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alexmumo.rickymorty.R

sealed class NavigationItem(
    val route: String,
    @DrawableRes val icon: Int?,
    @StringRes val title: Int?
) {
    object Home : NavigationItem("home", R.drawable.ic_home, R.string.home)
    object Details : NavigationItem("details/{id}", R.drawable.ic_home, R.string.details)
    object Search : NavigationItem("search", R.drawable.ic_search, R.string.search)
    object Episodes : NavigationItem("episodes", R.drawable.ic_episode, R.string.app_name)
    object Settings : NavigationItem("settings", R.drawable.ic_settings, R.string.settings)
    object Splash : NavigationItem("splash", R.drawable.ic_launcher_background, null)
}
