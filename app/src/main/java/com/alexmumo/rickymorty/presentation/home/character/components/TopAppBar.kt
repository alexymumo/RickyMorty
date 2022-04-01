package com.alexmumo.rickymorty.presentation.home.character.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TopBar() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text("RickyMorty")
                },
                backgroundColor = MaterialTheme.colors.primary
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        },
        drawerContent = {
            Text(text = "RickyMorty")
        },
        content = {
            Text(text = "RickyMorty App")
        },
        bottomBar = {
            BottomAppBar(backgroundColor = MaterialTheme.colors.primary) {
                Text(text = "Settings")
            }
        }
    )
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}
