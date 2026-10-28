package com.alanturing.pokeapp2627.features.pokemon

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PokeListScreen(
    onNavigateToHome: () -> Unit,
) {
    LazyColumn() {
        Text()

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onNavigateToDetails) {
            Text("Ver Pokemon")
        }
    }
}