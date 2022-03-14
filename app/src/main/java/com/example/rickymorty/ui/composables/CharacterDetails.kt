package com.example.rickymorty.ui.composables


import androidx.compose.runtime.Composable

@Composable
fun CharacterDetails() {

}


















/*




@Composable
fun SampleList(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"),
            contentDescription = "Android Robot",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text("AlexMumo#$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun SamplePhoto() {
    Row(modifier = Modifier
        .padding(8.dp)
        .clip(RoundedCornerShape(4.dp))
        .background(MaterialTheme.colors.surface)
        .clickable(onClick = {})
        .padding(16.dp)

    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {

        }
        Column(modifier = Modifier
            .padding(start = 8.dp)
            .align(Alignment.CenterVertically)
        ) {
            Text(text = "Alex Mumo", fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(text = "4 minutes", style = MaterialTheme.typography.body2)
            }
        }
    }
}




@Composable
fun CharacterScreen(
    openSearch: () -> Unit,
    openFilters: () -> Unit
) {
    Scaffold(topBar = {
        HomeAppBar(
            title = "RickyMorty",
            openSearch = openSearch,
            openFilters = openFilters)
    },
        content = {}
    )
}

@Preview(showBackground = true)
@Composable
fun SampleListPreview() {
}

@Preview(showBackground = true)
@Composable
fun SamplePhotoPreview(){
    SamplePhoto()
}


@Preview(showBackground = true)
@Composable
fun CharacterScreenPreview(){
    CharacterScreen(openSearch = { /*TODO*/ }) {

    }
}

 */








/*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.rickymorty.data.entity.Character
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
            //items(state) { character: Character ->
              //  CharacterCard(character = character)
            }
        }
    }
}

@Composable
fun CharacterCard(character: Character) {
  // val image = rememberImagePainter(data = character.imageUrl)
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
                    //Text(text = "Name: ${character.name}", textAlign = TextAlign.Left, color = Color.Cyan)
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                    //Text(text = "Origin: ${character.origin}", textAlign = TextAlign.Left, color = Color.Cyan)
                    Spacer(modifier = Modifier.padding(top = 5.dp))
                    //Text(text = "Gender: ${character.gender}", textAlign = TextAlign.Left, color = Color.Cyan)
                }
            }
        }
    }


    /*
    Card(
        modifier = Modifier
            .padding(bottom = 5.dp, top = 5.dp, end = 5.dp, start = 5.dp)
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
            Surface(
                color = MaterialTheme.colors.surface,
                contentColor = MaterialTheme.colors.primary
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .align(Alignment.BottomEnd)
                ) {
                    Text(text = "Name: ${character.name}")
                    Text(text = "Origin: ${character.origin}")
                    Text(text = "Gender: ${character.gender}")
                }
            }
        }
    }*/
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickyMortyTheme {
        CharacterInfo()
    }
}
*/

