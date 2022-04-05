package com.alexmumo.rickymorty.presentation.home.character.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

    if (state.errorMessage.isNotEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = state.errorMessage)
        }
    }

    characters?.let { items ->
        CharacterColumn(items = items, listState = lazyListState)
        Spacer(modifier = Modifier.height(80.dp))
        CharacterGrid(items = items, lazyGridState)
    }
}
