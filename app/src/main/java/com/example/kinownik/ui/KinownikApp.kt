package com.example.kinownik.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
private const val TITLE = "title/{titleId}"
private const val SESSION = "session"

@Composable
fun KinownikApp() {
    val nav = rememberNavController()
    NavHost(navController = nav, startDestination = WATCHLIST) {
        composable(WATCHLIST) {
            WatchlistScreen(
                onStart = { nav.navigate(EVENING) },
                onOpenTitle = { id -> nav.navigate("title/$id") },
                onOpenLibrary = { nav.openTab(LIBRARY) },
                onSearch = { nav.navigate(SEARCH) }
            )
        }
        composable(LIBRARY) {
            LibraryScreen(
                onOpenTitle = { id -> nav.navigate("title/$id") },
                onOpenWatchlist = { nav.openTab(WATCHLIST) },
                onSearch = { nav.navigate(SEARCH) }
            )
        }
        composable(EVENING) {
            EveningScreen(onBack = { nav.popBackStack() })
        }
        composable(SEARCH) {
            SearchScreen(onBack = { nav.popBackStack() })
        }
        composable(TITLE) { entry ->
            val titleId = entry.arguments?.getString("titleId")?.toIntOrNull() ?: 0
            TitleScreen(
                titleId = titleId,
                onBack = { nav.popBackStack() },
                onAddSession = { nav.navigate(SESSION) }
            )
        }
        composable(SESSION) {
            SessionScreen(onBack = { nav.popBackStack() })
        }
    }
}

private fun NavHostController.openTab(route: String) {
    navigate(route) {
        popUpTo(WATCHLIST)
        launchSingleTop = true
    }
}
