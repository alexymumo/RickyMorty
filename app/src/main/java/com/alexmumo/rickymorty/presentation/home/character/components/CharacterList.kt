package com.alexmumo.rickymorty.presentation.home.character.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexmumo.rickymorty.presentation.screens.common.TopBar
import com.alexmumo.rickymorty.presentation.screens.details.HomeViewModel
import com.alexmumo.rickymorty.presentation.ui.navigation.BottomNavigationBar
import org.koin.androidx.compose.getViewModel

@ExperimentalFoundationApi
@Composable
fun CharacterList(viewModel: HomeViewModel = getViewModel()) {
    val state = viewModel.characterState.value
    val lazyListState = rememberLazyListState()
    val lazyGridState = rememberLazyGridState()

    val characters = state.characterList?.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomNavigationBar()
        },
    ) {
        if (state.errorMessage.isNotEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = state.errorMessage)
            }
        }
        characters?.let { items ->
            // CharacterList(items = items, listState = lazyListState)
            CharacterColumn(items = items, listState = lazyListState)
            CharacterGrid(items = items, lazyGridState)
        }
    }
}
