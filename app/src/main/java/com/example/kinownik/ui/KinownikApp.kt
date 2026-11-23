package com.example.kinownik.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.kinownik.ui.screens.EveningScreen
import com.example.kinownik.ui.screens.LibraryScreen
import com.example.kinownik.ui.screens.SearchScreen
import com.example.kinownik.ui.screens.SessionScreen
import com.example.kinownik.ui.screens.TitleScreen
import com.example.kinownik.ui.screens.WatchlistScreen

private const val WATCHLIST = "watchlist"
private const val EVENING = "evening"
private const val LIBRARY = "library"
private const val SEARCH = "search"
private const val TITLE = "title"
private const val SESSION = "session"

@Composable
fun KinownikApp() {
    var stack by remember { mutableStateOf(listOf(WATCHLIST)) }
    val screen = stack.last()
    val openWatchlist = { stack = listOf(WATCHLIST) }
    val openLibrary = { stack = listOf(LIBRARY) }
    val back = { stack = stack.dropLast(1) }

    when (screen) {
        WATCHLIST -> WatchlistScreen(
            onStart = { stack = stack + EVENING },
            onOpenTitle = { stack = stack + TITLE },
            onOpenLibrary = openLibrary,
            onSearch = { stack = stack + SEARCH }
        )
        LIBRARY -> LibraryScreen(
            onOpenTitle = { stack = stack + TITLE },
            onOpenWatchlist = openWatchlist,
            onSearch = { stack = stack + SEARCH }
        )
        EVENING -> EveningScreen(onBack = back)
        SEARCH -> SearchScreen(onBack = back)
        TITLE -> TitleScreen(
            onBack = back,
            onAddSession = { stack = stack + SESSION }
        )
        SESSION -> SessionScreen(onBack = back)
    }
}
