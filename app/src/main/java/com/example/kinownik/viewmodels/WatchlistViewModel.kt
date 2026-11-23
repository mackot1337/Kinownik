package com.example.kinownik.viewmodels

import androidx.lifecycle.ViewModel
import com.example.kinownik.data.SampleData
import com.example.kinownik.data.Title
import com.example.kinownik.data.TitleStatus
import com.example.kinownik.data.TitleType
import kotlinx.coroutines.flow.MutableStateFlow

class WatchlistViewModel : ViewModel() {
    val titles = MutableStateFlow(titlesToWatch())

    fun addTrialTitle() {
        var nextId = 1
        for (title in SampleData.titles) {
            if (title.id >= nextId) {
                nextId = title.id + 1
            }
        }
        SampleData.titles.add(
            Title(
                id = nextId,
                tmdbId = null,
                name = "Próbny tytuł",
                year = "2026",
                type = TitleType.MOVIE,
                description = "Dopisany z przycisku. Po zamknięciu aplikacji znika.",
                audienceRating = "0",
                myRating = null,
                status = TitleStatus.TO_WATCH,
                runtimeOrSeasons = "90 min",
                posterPath = null,
                trailerKey = null,
                soundtrackPath = null
            )
        )
        titles.value = titlesToWatch()
    }
}

private fun titlesToWatch(): List<Title> {
    val result = ArrayList<Title>()
    for (title in SampleData.titles) {
        if (title.status == TitleStatus.TO_WATCH) {
            result.add(title)
        }
    }
    return result
}
