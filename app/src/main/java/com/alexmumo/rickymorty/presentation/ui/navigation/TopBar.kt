package com.alexmumo.rickymorty.presentation.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar() {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp),
                text = "RickyMorty",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                fontStyle = FontStyle.Italic,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h6,
            )
        },
    )
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}
