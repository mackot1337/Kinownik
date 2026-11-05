package com.example.kinownik.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private const val WATCHLIST = "watchlist"
private const val EVENING = "evening"
private const val LIBRARY = "library"
private const val SEARCH = "search"
private const val TITLE = "title"
private const val SESSION = "session"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KinownikApp() {
    var stack by remember { mutableStateOf(listOf(WATCHLIST)) }
    val screen = stack.last()
    val showBottomBar = screen == WATCHLIST || screen == LIBRARY

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = screenTitle(screen)) },
                navigationIcon = {
                    if (!showBottomBar) {
                        Button(onClick = { stack = stack.dropLast(1) }) {
                            Text(text = "Wstecz")
                        }
                    }
                }
            )
        },
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {
                    NavigationBarItem(
                        selected = screen == WATCHLIST,
                        onClick = { stack = listOf(WATCHLIST) },
                        icon = { Text(text = "1") },
                        label = { Text(text = "Do obejrzenia") }
                    )
                    NavigationBarItem(
                        selected = screen == LIBRARY,
                        onClick = { stack = listOf(LIBRARY) },
                        icon = { Text(text = "2") },
                        label = { Text(text = "Biblioteka") }
                    )
                }
            }
        },
        floatingActionButton = {
            if (showBottomBar) {
                FloatingActionButton(onClick = { stack = stack + SEARCH }) {
                    Text(text = "+")
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(20.dp)
                .fillMaxSize()
        ) {
            when (screen) {
                WATCHLIST -> WatchlistScreen(
                    onStart = { stack = stack + EVENING },
                    onOpenTitle = { stack = stack + TITLE }
                )
                EVENING -> EveningScreen()
                LIBRARY -> LibraryScreen(
                    onOpenTitle = { stack = stack + TITLE }
                )
                SEARCH -> SearchScreen()
                TITLE -> TitleScreen(
                    onAddSession = { stack = stack + SESSION }
                )
                SESSION -> SessionScreen()
            }
        }
    }
}

fun screenTitle(screen: String): String {
    return when (screen) {
        WATCHLIST -> "Do obejrzenia"
        EVENING -> "Na wieczór"
        LIBRARY -> "Biblioteka"
        SEARCH -> "Szukaj"
        TITLE -> "Tytuł"
        SESSION -> "Nowy seans"
        else -> "Kinownik"
    }
}
