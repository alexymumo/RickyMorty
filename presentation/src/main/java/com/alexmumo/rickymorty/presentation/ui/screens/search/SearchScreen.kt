package com.alexmumo.rickymorty.presentation.ui.screens.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.alexmumo.rickymorty.presentation.ui.bars.SearchBar
import com.alexmumo.rickymorty.presentation.ui.components.CharacterColumn
import org.koin.androidx.compose.getViewModel

@ExperimentalComposeUiApi
@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchViewModel = getViewModel()
) {
    val state = viewModel.search.value
    val characterlist = state.characterList?.collectAsLazyPagingItems()
    val searchTerm = viewModel.searchTerm.collectAsState().value
    LaunchedEffect(key1 = searchTerm) {
        if (searchTerm != "") {
            viewModel.searchByName(searchTerm)
        }
    }
    Scaffold(
        topBar = {
            SearchBar(
                value = searchTerm,
                onValueChange = { name ->
                    viewModel.search(name)
                },
                placeholder = "Search Characters",
            )
        }
    ) {
        characterlist?.let { searchString ->
            CharacterColumn(items = searchString)
        }
    }
}
