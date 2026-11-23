@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kinownik.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TitleScreen(
    onBack: () -> Unit,
    onAddSession: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Tytuł") },
                navigationIcon = {
                    Button(onClick = onBack) {
                        Text(text = "Wstecz")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Text(text = "Ekran tytułu.", modifier = Modifier.padding(20.dp))
            Button(onClick = onAddSession, modifier = Modifier.padding(20.dp)) {
                Text(text = "Dopisz seans")
            }
        }
    }
}
