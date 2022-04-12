package com.alexmumo.rickymorty.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SearchScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        maxLines = 1,
        textStyle = TextStyle(color = Color.Cyan, fontWeight = FontWeight.Bold),
        onValueChange = { text = it },
        label = { Text(text = "Search") },
        modifier = Modifier.padding(20.dp)
    )
}


