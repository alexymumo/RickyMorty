package com.alexmumo.rickymorty.presentation.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyGridState
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import coil.transform.CircleCropTransformation
import com.alexmumo.rickymorty.domain.models.Character

@Composable
fun GridList(
    character: Character,
    modifier: Modifier = Modifier,
    onClick: (Character) -> Unit
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.padding(8.dp)
            .clickable {
                onClick(character)
            }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CharacterCard(
                modifier = Modifier.fillMaxWidth(0.7f),
                characterImage = character.imageUrl,
                transformation = listOf(CircleCropTransformation())
            )
            CharacterInfo(
                character = character,
                alignment = Alignment.CenterHorizontally
            )
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun CharacterGrid(
    items: LazyPagingItems<Character>,
    listState: LazyGridState = rememberLazyGridState(),
    navigate: (Character) -> Unit = {}
) {
    LazyVerticalGrid(cells = GridCells.Fixed(2), state = listState) {
        items(items.itemCount) { index ->
            items[index]?.let {
                GridList(character = it, modifier = Modifier.animateContentSize()) {
                    navigate(it)
                }
            }
        }
    }
}
