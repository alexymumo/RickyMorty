package com.example.rickymorty.ui.composables

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickymorty.R
import com.example.rickymorty.ui.theme.RickyMortyTheme

@Composable
fun CharacterInfo(){

}

@Composable
fun CharacterCard() {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .animateContentSize(),
            shape = RoundedCornerShape(8.dp),
            elevation = 16.dp
        ) {
            Box {
                Image(
                    painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Spacer(modifier = Modifier.height(12.dp))
                Surface(
                    color = MaterialTheme.colors.surface,
                    modifier = Modifier.align(Alignment.BottomEnd),
                    contentColor = MaterialTheme.colors.primary
                ) {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp)) {
                        Text(text = "Name")
                        Text(text = "Character")
                        Text(text = "Alex")
                    }
                }
            }
        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickyMortyTheme {
        CharacterCard()
    }
}


//val characterViewModel = viewModel(modelClass = CharacterViewModel::class.java)

//val state by characterViewModel.state.collectAsState()

//LazyColumn {
/*if (state.isEmpty()){
    item {
        CircularProgressIndicator(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize()
                .wrapContentSize(align = Alignment.Center)
        )
    }
}
items(state){characters: CharacterData ->
    ImageCard(characters = characters)
}

 */
//}


//val image = rememberImagePainter(data = characters.image)

/*
Card(
    shape = RoundedCornerShape(15.dp),
    modifier = Modifier.padding(bottom = 5.dp, end = 5.dp, start = 5.dp, top = 5.dp)
        .fillMaxWidth(),
    elevation = 12.dp
) {
    Box {
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
                Text(text = "Actor: ${characters.species}")
                Text(text = "Origin ${characters.species}")

            }
        }

    }

}

 */


