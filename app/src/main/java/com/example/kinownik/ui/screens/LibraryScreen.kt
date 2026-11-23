@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kinownik.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kinownik.ui.AppBottomBar

@Composable
fun LibraryScreen(
    onOpenTitle: () -> Unit,
    onOpenWatchlist: () -> Unit,
    onSearch: () -> Unit
) {
    var query by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Biblioteka") })
        },
        bottomBar = {
            AppBottomBar(
                watchlistSelected = false,
                onOpenWatchlist = onOpenWatchlist,
                onOpenLibrary = { }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onSearch) {
                Text(text = "+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            TextField(
                value = query,
                onValueChange = { query = it },
                label = { Text(text = "Szukaj tytułu w bibliotece") }
            )
            Button(onClick = onOpenTitle, modifier = Modifier.padding(20.dp)) {
                Text(text = "Tytuł")
            }
        }
    }
}
