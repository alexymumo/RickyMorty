package com.alexmumo.rickymorty.presentation.ui.screens.details

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.getViewModel

@Composable
fun CharacterDetail(
    viewModel: DetailsViewModel = getViewModel()
) {

    val lazyListState = rememberLazyListState()
    val detailState = viewModel.state.value

    if (detailState.isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Card(shape = CircleShape) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(60.dp)
                        .padding(10.dp)
                )
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        detailState.characterDetail?.let { character ->

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = character.name,
                        style = MaterialTheme.typography.h4,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = character.species,
                        style = MaterialTheme.typography.h4,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
