package com.alexmumo.rickymorty.presentation.home.character.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.request.ImageRequest
import com.alexmumo.rickymorty.domain.models.Character
import com.skydoves.landscapist.CircularReveal
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
        circularReveal = CircularReveal(duration = 350),

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
}
