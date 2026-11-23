@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kinownik.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kinownik.data.dateInPolish
import com.example.kinownik.data.statusLabel
import com.example.kinownik.data.typeLabel
import com.example.kinownik.viewmodels.TitleViewModel
import com.example.kinownik.viewmodels.TitleViewModelFactory

@Composable
fun TitleScreen(
    titleId: Int,
    onBack: () -> Unit,
    onAddSession: () -> Unit
) {
    val model: TitleViewModel = viewModel(
        key = titleId.toString(),
        factory = remember(titleId) { TitleViewModelFactory(titleId) }
    )
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
        val title = model.title.collectAsState().value
        val sessions = model.sessions.collectAsState().value
        if (title == null) {
            Text(
                text = "Nie ma takiego tytułu.",
                modifier = Modifier.padding(padding).padding(20.dp)
            )
        } else {
            val rating = if (title.myRating == null) "brak" else "${title.myRating}/10"
            Column(
                modifier = Modifier
                    .padding(padding)
                    .padding(20.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(text = title.name)
                Text(text = "${title.year}  ${typeLabel(title.type)}  ${statusLabel(title.status)}")
                Text(text = title.description)
                Text(text = "Czas albo sezony: ${title.runtimeOrSeasons}")
                Text(text = "Ocena widzów: ${title.audienceRating}")
                Text(text = "Moja ocena: $rating")
                Text(text = "Gatunki: ${model.genreNames()}")
                Text(text = "Seanse", modifier = Modifier.padding(top = 16.dp))
                for (session in sessions) {
                    val place = model.placeName(session.placeId)
                    val placeText = if (place.isEmpty()) "bez miejsca" else place
                    Text(text = "${dateInPolish(session.date)}  ${session.watchedRange}  $placeText")
                }
                Button(onClick = onAddSession, modifier = Modifier.padding(20.dp)) {
                    Text(text = "Dopisz seans")
                }
            }
        }
    }
}
