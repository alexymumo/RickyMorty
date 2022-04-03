package com.alexmumo.rickymorty.presentation.home.character.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import coil.transform.CircleCropTransformation
import com.alexmumo.rickymorty.domain.models.Character

@Composable
fun GridList(character: Character, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.padding(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            CharacterCard(
                characterImage = character.imageUrl,
                modifier = Modifier.fillMaxWidth(0.7f)
            )
            CharacterInfo(character = character, alignment = Alignment.CenterHorizontally)
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

@Composable
fun CharacterInfo(
    character: Character,
    modifier: Modifier = Modifier,
    alignment: Alignment.Horizontal = Alignment.Start
) {
    val color = when (character.status) {
        "Alive" -> Color.Green
        "Dead" -> Color.Red
        else -> Color.Yellow
    }
    Column(
        modifier = modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = alignment
    ) {
        Text(
            text = character.name,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.caption,
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = character.gender,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.caption,
            maxLines = 1
        )
        Text(text = "Status", fontSize = 13.sp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(color = color, shape = CircleShape)
            )
            Text(text = character.status + " - " + character.species)
        }
    }
}
