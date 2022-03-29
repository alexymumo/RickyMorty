package com.example.rickymorty.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi

import android.content.Context
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberImagePainter
import com.example.rickymorty.R
import com.example.rickymorty.data.entity.Character
import com.example.rickymorty.data.local.entities.Characters
import com.example.rickymorty.ui.theme.RickyMortyTheme
import kotlinx.coroutines.flow.Flow


@Composable
fun HomeScreen() {

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

fun CharacterCard() {
    Card(elevation = 20.dp,
        backgroundColor = Color.Cyan,
        modifier = Modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(10.dp))
            .height(250.dp)
            .fillMaxWidth()
    ) {
        ConstraintLayout {
            val (image, name, species) = createRefs()
            Image(
                contentScale = ContentScale.Crop,
                painter = rememberImagePainter(
                    data = null,
                    builder = {
                        placeholder(R.drawable.ic_launcher_background).crossfade(true)
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "RickyMorty",
                color = Color(0xFFF00234),
                maxLines = 2,
                fontWeight = FontWeight.Bold,
                modifier =
                Modifier
                    .constrainAs(name) {
                        top.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(species) {
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Text(
                    text = "Downloads",
                    color = Color(0xFFF234F),
                    modifier = Modifier.padding(8.dp),
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Downloads",
                    color = Color(0xFFF234F),
                    modifier = Modifier.padding(8.dp),
                    fontSize = 18.sp
                )
fun CharacterCard(character: Characters) {
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


@ExperimentalFoundationApi
@Composable
fun CharacterListing(characters: Flow<PagingData<Character>>) {
    val lazyCharacterItems = characters.collectAsLazyPagingItems()
    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
        items(lazyCharacterItems.itemCount) { index ->
            lazyCharacterItems[index]?.let { CharacterCard()
            }
        }
        lazyCharacterItems.apply {
            when {
                loadState.refresh is
                        LoadState.Loading -> {
                            item { CharacterLoading() }
                            item { CharacterLoading() }
                        }
                loadState.append is
                        LoadState.Loading -> {
                            item { CharacterLoading() }
                            item { CharacterLoading() }
                        }
                loadState.refresh is
                        LoadState.Error -> {}
                loadState.append is
                        LoadState.Error -> {}
            }
        }
    })
}

@Composable
fun CharacterLoading() {
    CircularProgressIndicator(
        modifier =
        Modifier
            .testTag("Loading")
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}


@Preview(showBackground = true)
@Composable
fun CharacterLoadingPreview() {
    CharacterLoading()
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun CharacterListingPreview() {
    //CharacterListing(characters = "Alex")
}

@Preview(showBackground = true)
@Composable
fun CharacterCardPreview() {
    CharacterCard()

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickyMortyTheme {
    }
}































<<<<<<< HEAD





























=======
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
>>>>>>> compose



