package com.example.rickymorty

import android.bluetooth.le.ScanRecord
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rickymorty.ui.theme.RickyMortyTheme
import com.example.rickymorty.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val characterViewModel: CharacterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickyMortyTheme {
                MainScreen(characterViewModel)
            }
        }
    }
}

@Composable
fun MainScreen(characterViewModel: CharacterViewModel){
    val characters = characterViewModel.characters.collectAsLazyPagingItems()

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickyMortyTheme {
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