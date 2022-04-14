package com.alexmumo.rickymorty.presentation.screens

import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavController
import com.alexmumo.rickymorty.presentation.home.viewmodel.DetailsViewModel
import org.koin.androidx.compose.getViewModel
import timber.log.Timber

@Composable
fun DetailScreen(
    navController: NavController,
    detailsViewModel: DetailsViewModel = getViewModel(),
    id: Int,
) {
    val lazyListState = rememberLazyListState()
    val detailState = detailsViewModel.state.value
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
                    Timber.e("Movie Details $id")
                }
            }
        }
    }
}
