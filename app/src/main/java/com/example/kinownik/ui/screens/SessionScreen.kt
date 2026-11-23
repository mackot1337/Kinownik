@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kinownik.ui.screens

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
fun SessionScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Nowy seans") },
                navigationIcon = {
                    Button(onClick = onBack) {
                        Text(text = "Wstecz")
                    }
                }
            )
        }
    ) { padding ->
        Text(
            text = "Ekran nowego seansu.",
            modifier = Modifier.padding(padding).padding(20.dp)
        )
    }
}
