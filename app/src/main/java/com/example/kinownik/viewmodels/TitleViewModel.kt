package com.example.kinownik.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kinownik.data.SampleData
import com.example.kinownik.data.Session
import com.example.kinownik.data.Title
import kotlinx.coroutines.flow.MutableStateFlow

class TitleViewModel(private val titleId: Int) : ViewModel() {
    val title = MutableStateFlow<Title?>(null)
    val sessions = MutableStateFlow(listOf<Session>())

    init {
        for (item in SampleData.titles) {
            if (item.id == titleId) {
                title.value = item
            }
        }
        val found = ArrayList<Session>()
        for (session in SampleData.sessions) {
            if (session.titleId == titleId) {
                found.add(session)
            }
        }
        found.sortByDescending { session -> session.date }
        sessions.value = found
    }

    fun placeName(placeId: Int?): String {
        if (placeId == null) {
            return ""
        }
        for (place in SampleData.places) {
            if (place.id == placeId) {
                return place.name
            }
        }
        return ""
    }

    fun genreNames(): String {
        var text = ""
        for (link in SampleData.titleGenres) {
            if (link.titleId != titleId) {
                continue
            }
            for (genre in SampleData.genres) {
                if (genre.id != link.genreId) {
                    continue
                }
                if (text.isEmpty()) {
                    text = genre.name
                } else {
                    text = text + ", " + genre.name
                }
            }
        }
        return text
    }
}

class TitleViewModelFactory(private val titleId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return TitleViewModel(titleId) as T
    }
}
