package com.example.rickymorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickymorty.ui.composables.MainScreen
import com.example.rickymorty.ui.theme.RickyMortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickyMortyTheme {
                Surface(color = MaterialTheme.colors.surface) {
                    Scaffold(content = { ShowMainScreen() })
                }
            }
        }
    }
}
@Composable
fun ShowMainScreen(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        MainScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickyMortyTheme {
        ShowMainScreen()
    }
}