package com.alexmumo.rickymorty.presentation.screens.details

import android.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexmumo.rickymorty.presentation.home.character.components.CharacterCard
import com.alexmumo.rickymorty.presentation.home.viewmodel.DetailsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun CharacterDetail(viewModel: DetailsViewModel = getViewModel()) {

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
                    CharacterCard(
                        character.image,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp))
                            .graphicsLayer {
                            }
                    )
                    Text(
                        text = character.name,
                        style = MaterialTheme.typography.h4,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val color = when (character.status) {
                            "Alive" -> Color.GREEN
                            "Dead" -> Color.RED
                            else -> Color.GRAY
                        }
                        Box(
                            modifier = Modifier
                                .size(14.dp)
                                .clip(CircleShape)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = character.status, style = MaterialTheme.typography.body1)
                    }
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

@Preview
@Composable
fun CharacterDetailPreview() {
    CharacterDetail()
}
