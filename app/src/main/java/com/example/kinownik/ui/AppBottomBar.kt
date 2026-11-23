package com.example.kinownik.ui

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AppBottomBar(
    watchlistSelected: Boolean,
    onOpenWatchlist: () -> Unit,
    onOpenLibrary: () -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = watchlistSelected,
            onClick = onOpenWatchlist,
            icon = { Text(text = "1") },
            label = { Text(text = "Do obejrzenia") }
        )
        NavigationBarItem(
            selected = !watchlistSelected,
            onClick = onOpenLibrary,
            icon = { Text(text = "2") },
            label = { Text(text = "Biblioteka") }
        )
    }
}
