package com.alexmumo.rickymorty.presentation.home.character

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexmumo.rickymorty.presentation.home.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel

@ExperimentalFoundationApi
@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel()) {
    val character = viewModel.characterState.value
    val characters = character.characterList?.collectAsLazyPagingItems()
    val lazyListState = rememberLazyListState()
    val lazyGridState = rememberLazyGridState()
}

