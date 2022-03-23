package com.example.rickymorty.ui.composables

import android.content.Context
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.rickymorty.data.local.entities.Character
import com.example.rickymorty.ui.theme.RickyMortyTheme
import com.example.rickymorty.viewmodel.CharacterViewModel

@Composable
fun CharacterInfo(){
    val characterViewModel = viewModel(modelClass = CharacterViewModel::class.java)
    val state by characterViewModel.state.collectAsState()
    LazyColumn {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .wrapContentSize()
                    .wrapContentSize(align = Alignment.Center)
                )
            }
        }
        else {
            items(state) { character : Character ->
                CharacterCard(character = character)
            }
        }
    }
}

@Composable
fun CharacterCard(character: Character) {
    val image = rememberImagePainter(data = character.image)
    Column {
        Card(
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = 16.dp) {
            Column {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier.height(200.dp),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Name: ${character.name}", textAlign = TextAlign.Left, color = Color.Cyan)
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                    Text(text = "Origin: ${character.species}", textAlign = TextAlign.Left, color = Color.Cyan)
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                    Text(text = "Gender: ${character.gender}", textAlign = TextAlign.Left, color = Color.Cyan)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickyMortyTheme {
    }
}































/*val image = rememberImagePainter(data = character.image)
Column {
    Card(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 16.dp) {
        Column {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.height(200.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Name: ${character.name}", textAlign = TextAlign.Left, color = Color.Cyan)
                Spacer(modifier = Modifier.padding(top = 5.dp))
                Text(text = "Origin: ${character.species}", textAlign = TextAlign.Left, color = Color.Cyan)
                Spacer(modifier = Modifier.padding(top = 5.dp))
                Text(text = "Gender: ${character.gender}", textAlign = TextAlign.Left, color = Color.Cyan)
            }
        }
    }
}*/

/* val characterViewModel = viewModel(modelClass = CharacterViewModel::class.java)
    val state by characterViewModel.state.collectAsState()
    LazyColumn {
        if (state.isEmpty()) {
            item {
                CircularProgressIndicator(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .wrapContentSize()
                    .wrapContentSize(align = Alignment.Center)
                )
            }
        }
        else {
            items(state) { character : Character ->
                CharacterCard(character = character)
            }
        }
    }
    */



