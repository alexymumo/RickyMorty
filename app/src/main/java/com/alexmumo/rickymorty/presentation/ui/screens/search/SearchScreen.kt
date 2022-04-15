package com.alexmumo.rickymorty.presentation.ui.screens.search

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.navigation.NavController

@Composable
fun SearchScreen(
    navController: NavController
) {
    var text by remember { mutableStateOf("Alex") }
    OutlinedTextField(value = text, onValueChange = { text = it })
}
