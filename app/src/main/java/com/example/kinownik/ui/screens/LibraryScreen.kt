@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kinownik.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kinownik.data.Session
import com.example.kinownik.data.dateInPolish
import com.example.kinownik.data.monthName
import com.example.kinownik.data.statusLabel
import com.example.kinownik.ui.AppBottomBar
import com.example.kinownik.viewmodels.LibraryViewModel

@Composable
fun LibraryScreen(
    onOpenTitle: (Int) -> Unit,
    onOpenWatchlist: () -> Unit,
    onSearch: () -> Unit
) {
    val model: LibraryViewModel = viewModel()
    val query = model.query.collectAsState().value
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
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            TextField(
                value = query,
                onValueChange = { model.query.value = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Szukaj tytułu w bibliotece") }
            )
            var lastMonth = ""
            for (session in model.visibleSessions()) {
                val month = monthName(session.date)
                if (month != lastMonth) {
                    Text(text = month, modifier = Modifier.padding(top = 16.dp))
                    lastMonth = month
                }
                SessionButton(session, model, onOpenTitle)
            }
        }
    }
}

@Composable
private fun SessionButton(
    session: Session,
    model: LibraryViewModel,
    onOpenTitle: (Int) -> Unit
) {
    val title = model.titleOf(session.titleId)
    val name = if (title == null) "" else title.name
    val status = if (title == null) "" else statusLabel(title.status)
    val rating = if (title == null || title.myRating == null) "brak oceny" else "${title.myRating}/10"
    val place = model.placeName(session.placeId)
    Button(onClick = { onOpenTitle(session.titleId) }, modifier = Modifier.padding(8.dp)) {
        Text(text = "$name  ${dateInPolish(session.date)}  ${session.watchedRange}  $status  $rating  $place")
    }
}
