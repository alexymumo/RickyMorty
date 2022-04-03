package com.alexmumo.rickymorty.presentation.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Episodes,
        NavigationItem.Settings,
        NavigationItem.Location
    )
    BottomNavigation(
        backgroundColor = Color.Red,
        contentColor = Color.White
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                selected = item.title == "Home",
                onClick = {},
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar()
}
