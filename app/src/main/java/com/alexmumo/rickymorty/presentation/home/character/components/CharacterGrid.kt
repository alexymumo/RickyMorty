package com.alexmumo.rickymorty.presentation.home.character.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.alexmumo.rickymorty.domain.models.Character

@Composable
fun GridList(character: Character, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CharacterInfo(character = character)
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun CharacterGrid(
    items: LazyPagingItems<Character>,
    listState: LazyGridState = rememberLazyGridState()
) {
    LazyVerticalGrid(cells = GridCells.Fixed(2), state = listState) {
        items(items.itemCount) { index ->
            items[index]?.let {
                GridList(character = it, modifier = Modifier.animateContentSize())
            }
        }
    }
}
