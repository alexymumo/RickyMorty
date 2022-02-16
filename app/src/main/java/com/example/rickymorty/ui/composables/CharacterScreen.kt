package com.example.rickymorty.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.rickymorty.data.entity.Characters
import com.example.rickymorty.viewmodel.CharacterViewModel

@Composable
fun MainScreen(){
    val characterViewModel = viewModel(modelClass = CharacterViewModel::class.java)
    val state by characterViewModel.state.collectAsState()
    
    LazyColumn {
        if (state.isEmpty()){
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }
        items(state){characters: Characters ->
            ImageCard(characters = characters)
        }
    }
}
@Composable
fun ImageCard(characters: Characters){
    val image = rememberImagePainter(data = characters.image)
    
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
    ) {
        Box() {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.padding(200.dp),
                contentScale = ContentScale.FillBounds
            )
            Surface(
                color = MaterialTheme.colors.onSurface.copy(alpha = .3f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colors.surface
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)) {
                    Text(text = "Name: ${characters.name}")
                    Text(text = "Actor: ${characters.origin}")
                    
                }
            }
            
        }

    }

}