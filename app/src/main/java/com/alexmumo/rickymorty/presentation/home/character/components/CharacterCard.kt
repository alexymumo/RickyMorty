package com.alexmumo.rickymorty.presentation.home.character.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.alexmumo.rickymorty.domain.models.Character
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun CharacterUI(character: Character, modifier: Modifier = Modifier) {
    AnimatedVisibility(visible = true) {
        Card(
            modifier = modifier
                .animateContentSize()
                .padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp
        ) {
            Row {
                CharacterCard(
                    character = character,
                    characterImage = character.imageUrl
                )
                CharacterInfo(
                    character = character,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun CharacterCard(characterImage: String, character: Character) {
    CoilImage(
        imageRequest =
        ImageRequest
            .Builder(LocalContext.current)
            .data(characterImage)
            .crossfade(true)
            .build(),
        alignment = Alignment.Center,

        loading = {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        failure = {
            Text(text = "Failed to load image")
        }
    )
    /*val imagePainter = rememberImagePainter(data = character.imageUrl)
    Image(
        painter = imagePainter,
        contentDescription = null
    )

     */
}

@Composable
fun CharacterInfo(character: Character) {
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
