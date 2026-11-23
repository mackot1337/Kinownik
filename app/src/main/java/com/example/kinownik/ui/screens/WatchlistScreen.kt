@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kinownik.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kinownik.ui.AppBottomBar

@Composable
fun WatchlistScreen(
    onStart: () -> Unit,
    onOpenTitle: () -> Unit,
    onOpenLibrary: () -> Unit,
    onSearch: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Do obejrzenia") })
        },
        bottomBar = {
            AppBottomBar(
                watchlistSelected = true,
                onOpenWatchlist = { },
                onOpenLibrary = onOpenLibrary
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onSearch) {
                Text(text = "+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Text(text = "Chcę obejrzeć")
            Button(onClick = onStart, modifier = Modifier.padding(20.dp)) {
                Text(text = "Zacznij")
            }
            Button(onClick = onOpenTitle, modifier = Modifier.padding(20.dp)) {
                Text(text = "Tytuł")
            }
        }
    }
}
