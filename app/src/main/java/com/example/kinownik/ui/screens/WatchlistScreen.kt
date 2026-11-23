@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kinownik.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kinownik.data.Title
import com.example.kinownik.data.typeLabel
import com.example.kinownik.ui.AppBottomBar
import com.example.kinownik.viewmodels.WatchlistViewModel

@Composable
fun WatchlistScreen(
    onStart: () -> Unit,
    onOpenTitle: (Int) -> Unit,
    onOpenLibrary: () -> Unit,
    onSearch: () -> Unit
) {
    val model: WatchlistViewModel = viewModel()
    val titles = model.titles.collectAsState().value
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
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "Chcę obejrzeć")
            Button(onClick = onStart, modifier = Modifier.padding(20.dp)) {
                Text(text = "Zacznij")
            }
            for (title in titles) {
                TitleButton(title, onOpenTitle)
            }
            Button(onClick = { model.addTrialTitle() }, modifier = Modifier.padding(20.dp)) {
                Text(text = "Dodaj próbny tytuł")
            }
        }
    }
}

@Composable
private fun TitleButton(title: Title, onOpenTitle: (Int) -> Unit) {
    Button(onClick = { onOpenTitle(title.id) }, modifier = Modifier.padding(8.dp)) {
        Text(text = "${title.name}  ${title.year}  ${typeLabel(title.type)}")
    }
}
