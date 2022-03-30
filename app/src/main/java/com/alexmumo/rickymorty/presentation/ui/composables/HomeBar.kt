package com.alexmumo.rickymorty.presentation.ui.composables

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeAppBar(
    title: String,
    openSearch: () -> Unit,
    openFilters: () -> Unit) {

    TopAppBar(
        title = { Text(text = title,
            color = Color.White)},
        backgroundColor = Color(0xFFF51178),
        actions = {
            IconButton(onClick = openSearch) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.Green
                )
            }
            IconButton(onClick = openFilters) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Filter",
                    tint = Color.Blue
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeAppBarPreview() {
    HomeAppBar(
        title = "RickyMorty",
        openSearch = {},
        openFilters = {}
    )
}
