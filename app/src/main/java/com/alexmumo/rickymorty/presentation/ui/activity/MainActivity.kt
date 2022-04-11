package com.alexmumo.rickymorty.presentation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.alexmumo.rickymorty.presentation.screens.MainScreen
import com.alexmumo.rickymorty.presentation.ui.theme.RickyMortyTheme

@ExperimentalAnimationApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickyMortyTheme {
                MainScreen()
                // CharacterList()
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickyMortyTheme {
        MainScreen()
    }
}
