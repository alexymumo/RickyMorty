package com.alexmumo.rickymorty.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.alexmumo.rickymorty.presentation.home.character.components.CharacterList
import com.alexmumo.rickymorty.presentation.ui.navigation.BottomNavigationBar
import com.alexmumo.rickymorty.presentation.ui.navigation.TopBar

@ExperimentalFoundationApi
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },

        content = {
            CharacterList()
        },
        bottomBar = { BottomNavigationBar() },
    ){
        Navigation(navController)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreenPreview()
}
