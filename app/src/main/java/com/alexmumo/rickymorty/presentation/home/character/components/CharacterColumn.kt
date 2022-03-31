package com.alexmumo.rickymorty.presentation.home.character.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items

@Composable
fun CharacterColumn(
    items: LazyPagingItems<Character>,
    listState: LazyListState = rememberLazyListState()
) {
    LazyColumn(
        state = listState,
        // modifier = Modifier

    ) {
        items(items) { character ->
            CharacterUI(character = character!!)
        }
    }
    items.apply {
        when {
            loadState.refresh is LoadState.Loading -> {

            }
            loadState.refresh is LoadState.Error -> {

            }

        }
    }
}
