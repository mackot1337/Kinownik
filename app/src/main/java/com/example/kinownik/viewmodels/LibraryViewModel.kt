package com.example.kinownik.viewmodels

import androidx.lifecycle.ViewModel
import com.example.kinownik.data.Place
import com.example.kinownik.data.SampleData
import com.example.kinownik.data.Session
import com.example.kinownik.data.Title
import kotlinx.coroutines.flow.MutableStateFlow

class LibraryViewModel : ViewModel() {
    val sessions = MutableStateFlow(listOf<Session>())
    val titles = MutableStateFlow(listOf<Title>())
    val places = MutableStateFlow(listOf<Place>())
    val query = MutableStateFlow("")

    init {
        val sessionCopy = ArrayList<Session>()
        for (session in SampleData.sessions) {
            sessionCopy.add(session)
        }
        sessionCopy.sortByDescending { session -> session.date }
        sessions.value = sessionCopy

        val titleCopy = ArrayList<Title>()
        for (title in SampleData.titles) {
            titleCopy.add(title)
        }
        titles.value = titleCopy

        val placeCopy = ArrayList<Place>()
        for (place in SampleData.places) {
            placeCopy.add(place)
        }
        places.value = placeCopy
    }

    fun visibleSessions(): List<Session> {
        val text = query.value.trim()
        val result = ArrayList<Session>()
        for (session in sessions.value) {
            val name = titleName(session.titleId)
            val matches = text.isEmpty() || name.contains(text, ignoreCase = true)
            if (matches) {
                result.add(session)
            }
        }
        return result
    }

    fun titleOf(titleId: Int): Title? {
        for (title in titles.value) {
            if (title.id == titleId) {
                return title
            }
        }
        return null
    }

    fun titleName(titleId: Int): String {
        val title = titleOf(titleId)
        if (title == null) {
            return ""
        }
        return title.name
    }

    fun placeName(placeId: Int?): String {
        if (placeId == null) {
            return ""
        }
        for (place in places.value) {
            if (place.id == placeId) {
                return place.name
            }
        }
        return ""
    }
}
