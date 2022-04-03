package com.alexmumo.rickymorty.presentation.screens.common

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "RickyMorty") },
        backgroundColor = Color.Green,
        contentColor = Color.White
    )
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}

