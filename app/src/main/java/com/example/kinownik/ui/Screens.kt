package com.example.kinownik.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WatchlistScreen(onStart: () -> Unit, onOpenTitle: () -> Unit) {
    Column {
        Text(text = "Lista filmów i seriali, które chcę obejrzeć.")
        Button(onClick = onStart, Modifier.padding(20.dp)) {
            Text(text = "Zacznij")
        }
        Button(onClick = onOpenTitle, Modifier.padding(20.dp)) {
            Text(text = "Otwórz tytuł")
        }
    }
}

@Composable
fun EveningScreen() {
    Text(text = "Tutaj będą pytania i sześć propozycji.")
}

@Composable
fun LibraryScreen(onOpenTitle: () -> Unit) {
    Column {
        Text(text = "Tutaj będą seanse pogrupowane miesiącami.")
        Button(onClick = onOpenTitle, Modifier.padding(20.dp)) {
            Text(text = "Otwórz tytuł")
        }
    }
}

@Composable
fun SearchScreen() {
    Text(text = "Tutaj będzie wyszukiwanie tytułu w bazie.")
}

@Composable
fun TitleScreen(onAddSession: () -> Unit) {
    Column {
        Text(text = "Ekran tytułu.")
        Button(onClick = onAddSession, Modifier.padding(20.dp)) {
            Text(text = "Dopisz seans")
        }
    }
}

@Composable
fun SessionScreen() {
    Text(text = "Ekran nowego seansu.")
}
