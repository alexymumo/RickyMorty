package com.alexmumo.rickymorty.presentation.home.character.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.alexmumo.rickymorty.domain.models.Character

@Composable
fun CharacterUI(character: java.lang.Character, modifier: Modifier = Modifier) {
    AnimatedVisibility(visible = true) {
        Card(
            modifier = modifier
                .animateContentSize()
                .padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp
        ) {
            Row() {
                CharacterInfo(character = character)
            }
        }
    }
}

@Composable
fun CharacterCard(character: Character) {
    val imagePainter = rememberImagePainter(data = character.imageUrl)
    Image(
        painter = imagePainter,
        contentDescription = null,
    )
}

@Composable
fun CharacterInfo(
    character: Character
) {
    Column {
        Text(
            text = character.name,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = character.gender,
            fontWeight = FontWeight.Black,
            maxLines = 1
        )
    }
}
