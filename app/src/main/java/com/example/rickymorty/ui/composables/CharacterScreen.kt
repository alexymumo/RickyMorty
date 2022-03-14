package com.example.rickymorty.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import kotlinx.coroutines.flow.Flow


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

                        }
                loadState.append is
                        LoadState.Loading -> {

                        }
                loadState.refresh is
                        LoadState.Error -> {}
                loadState.append is
                        LoadState.Error -> {}
            }
        }
    })
}

/*Progress bar*/
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

/*Previews*/
@Preview(showBackground = true)
@Composable
fun CharacterLoadingPreview() {
    CharacterLoading()
}

@Preview(showBackground = true)
@Composable
fun CharacterListingPreview() {
   // CharacterListing()
}

@Preview(showBackground = true)
@Composable
fun CharacterCardPreview() {
    CharacterCard()
}































































