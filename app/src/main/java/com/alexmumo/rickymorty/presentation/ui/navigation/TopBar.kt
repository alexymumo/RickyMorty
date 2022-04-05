package com.alexmumo.rickymorty.presentation.ui.navigation

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(text = "RickyMorty", fontSize = 18.sp)
        },
        backgroundColor = Color.Red,
        contentColor = Color.White
    )
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}
