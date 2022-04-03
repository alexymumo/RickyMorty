package com.alexmumo.rickymorty.presentation.home.character.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.alexmumo.rickymorty.domain.models.Character

@ExperimentalFoundationApi
@Composable
fun CharacterColumn(
    items: LazyPagingItems<Character>,
    listState: LazyListState = rememberLazyListState()
) {
    LazyColumn(
        state = listState,
        modifier = Modifier

    ) {
        items(items) { character ->
            CharacterUI(character = character!!, modifier = Modifier.animateItemPlacement())
        }
        items.apply {
            when {
                // refresh
                loadState.refresh is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(
                                    top = 40.dp,
                                    bottom = 50.dp
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.height(30.dp))
                        }
                    }
                }
                // reload
                loadState.append is LoadState.Loading -> {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth()
                                .padding(bottom = 50.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.height(30.dp))
                        }
                    }
                }

                // refresh error
                loadState.refresh is LoadState.Error -> {
                    val errorMessage = items.loadState.refresh as LoadState.Error
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth()
                                .padding(bottom = 50.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                val error = if (errorMessage.error.localizedMessage!!.contains("404")
                                ) "Error 404"
                                else
                                    errorMessage.error.localizedMessage
                                Text(error)
                            }
                        }
                    }
                }
                // reload error
                loadState.append is LoadState.Error -> {
                    val errorMessage = items.loadState.append as LoadState.Error
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 50.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(text = errorMessage.error.localizedMessage!!)
                                Button(onClick = { retry() }) {
                                    Text(text = "Try Again")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
