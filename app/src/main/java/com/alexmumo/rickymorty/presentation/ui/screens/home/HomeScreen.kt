package com.alexmumo.rickymorty.presentation.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyGridState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexmumo.rickymorty.presentation.ui.components.CharacterGrid
import org.koin.androidx.compose.getViewModel

@ExperimentalFoundationApi
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = getViewModel()
) {
    val state = viewModel.characterState.value
    val lazyGridState = rememberLazyGridState()
    val characters = state.characterList?.collectAsLazyPagingItems()
    if (state.errorMessage.isNotEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = state.errorMessage)
        }
    }
    characters?.let { items ->
        CharacterGrid(items = items, lazyGridState)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreenPreview()
}
