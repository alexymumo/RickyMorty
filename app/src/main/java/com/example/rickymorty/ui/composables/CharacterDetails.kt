package com.example.rickymorty.ui.composables

import androidx.compose.runtime.Composable

@Composable
fun CharacterDetails() {

}
/*
   val characters = characterViewModel.characters.collectAsLazyPagingItems()

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
*
* */