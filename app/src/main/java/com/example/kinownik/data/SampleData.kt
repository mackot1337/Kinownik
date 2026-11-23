package com.example.kinownik.data

object SampleData {
    val titles = ArrayList<Title>()
    val sessions = ArrayList<Session>()
    val places = ArrayList<Place>()
    val genres = ArrayList<Genre>()
    val titleGenres = ArrayList<TitleGenre>()

    init {
        places.add(Place(id = 1, name = "Kraków", latitude = 50.0614, longitude = 19.9366))
        places.add(Place(id = 2, name = "Dom", latitude = null, longitude = null))

        genres.add(Genre(id = 1, name = "Dramat", tmdbId = 18))
        genres.add(Genre(id = 2, name = "Komedia", tmdbId = 35))
        genres.add(Genre(id = 3, name = "Thriller", tmdbId = 53))
        genres.add(Genre(id = 4, name = "Sci-fi", tmdbId = 878))
        genres.add(Genre(id = 5, name = "Animacja", tmdbId = 16))
        genres.add(Genre(id = 6, name = "Dokument", tmdbId = 99))

        titles.add(movie(1, "Dune: Part Two", "2024", "Druga część historii Paula Atrydy na Arrakis.", "8.6", 9, TitleStatus.WATCHED, "166 min"))
        titles.add(series(2, "The Bear", "2022", "Kucharz wraca do rodzinnej restauracji w Chicago.", "8.7", null, TitleStatus.IN_PROGRESS, "3 sezony"))
        titles.add(movie(3, "Interstellar", "2014", "Załoga leci przez tunel w czasie szukać nowego domu.", "8.7", null, TitleStatus.TO_WATCH, "169 min"))
        titles.add(series(4, "Dune: Prophecy", "2024", "Początki zakonu Bene Gesserit.", "7.4", null, TitleStatus.TO_WATCH, "1 sezon"))

        sessions.add(Session(id = 1, titleId = 1, date = "2026-03-12", watchedRange = "Cały film", placeId = 1, photoPath = null))
        sessions.add(Session(id = 2, titleId = 2, date = "2026-03-04", watchedRange = "S02E04–E06", placeId = 2, photoPath = null))
        sessions.add(Session(id = 3, titleId = 1, date = "2026-01-18", watchedRange = "Cały film", placeId = null, photoPath = null))

        titleGenres.add(TitleGenre(titleId = 1, genreId = 1))
        titleGenres.add(TitleGenre(titleId = 1, genreId = 4))
        titleGenres.add(TitleGenre(titleId = 2, genreId = 1))
        titleGenres.add(TitleGenre(titleId = 3, genreId = 4))
        titleGenres.add(TitleGenre(titleId = 4, genreId = 4))
    }
}

private fun movie(
    id: Int,
    name: String,
    year: String,
    description: String,
    audienceRating: String,
    myRating: Int?,
    status: TitleStatus,
    runtimeOrSeasons: String
): Title {
    return Title(
        id = id,
        tmdbId = null,
        name = name,
        year = year,
        type = TitleType.MOVIE,
        description = description,
        audienceRating = audienceRating,
        myRating = myRating,
        status = status,
        runtimeOrSeasons = runtimeOrSeasons,
        posterPath = null,
        trailerKey = null,
        soundtrackPath = null
    )
}

private fun series(
    id: Int,
    name: String,
    year: String,
    description: String,
    audienceRating: String,
    myRating: Int?,
    status: TitleStatus,
    runtimeOrSeasons: String
): Title {
    return Title(
        id = id,
        tmdbId = null,
        name = name,
        year = year,
        type = TitleType.SERIES,
        description = description,
        audienceRating = audienceRating,
        myRating = myRating,
        status = status,
        runtimeOrSeasons = runtimeOrSeasons,
        posterPath = null,
        trailerKey = null,
        soundtrackPath = null
    )
}
