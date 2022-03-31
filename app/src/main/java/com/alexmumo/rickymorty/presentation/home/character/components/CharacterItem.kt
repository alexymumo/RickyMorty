package com.alexmumo.rickymorty.presentation.home.character.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.alexmumo.rickymorty.domain.models.Character
import com.alexmumo.rickymorty.presentation.home.viewmodel.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun CharacterItem(character: Character, viewModel: HomeViewModel = getViewModel()) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val painter = rememberImagePainter(
                data = character.imageUrl
            )
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .height(220.dp),
                painter = painter,
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
    }
}
