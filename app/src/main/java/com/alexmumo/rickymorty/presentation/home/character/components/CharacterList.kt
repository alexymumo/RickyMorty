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
import com.alexmumo.rickymorty.presentation.screens.details.HomeViewModel
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
           /* TopAppBar(
                modifier = Modifier.height(80.dp),
                title = { Text(text = "RickyMorty") },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )

            */
        },
        floatingActionButtonPosition = FabPosition.End
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
