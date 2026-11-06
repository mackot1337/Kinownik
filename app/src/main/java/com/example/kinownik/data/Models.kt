package com.example.kinownik.data

enum class TitleType {
    MOVIE,
    SERIES
}

enum class TitleStatus {
    TO_WATCH,
    IN_PROGRESS,
    WATCHED
}

data class Title(
    val id: Int,
    val tmdbId: Int?,
    val name: String,
    val year: String,
    val type: TitleType,
    val description: String,
    val audienceRating: String,
    val myRating: Int?,
    val status: TitleStatus,
    val runtimeOrSeasons: String,
    val posterPath: String?,
    val trailerKey: String?,
    val soundtrackPath: String?
)

data class Session(
    val id: Int,
    val titleId: Int,
    val date: String,
    val watchedRange: String,
    val placeId: Int?,
    val photoPath: String?
)

data class Place(
    val id: Int,
    val name: String,
    val latitude: Double?,
    val longitude: Double?
)

data class Genre(
    val id: Int,
    val name: String,
    val tmdbId: Int?
)

data class TitleGenre(
    val titleId: Int,
    val genreId: Int
)

fun typeLabel(type: TitleType): String {
    return when (type) {
        TitleType.MOVIE -> "film"
        TitleType.SERIES -> "serial"
    }
}

fun statusLabel(status: TitleStatus): String {
    return when (status) {
        TitleStatus.TO_WATCH -> "Do obejrzenia"
        TitleStatus.IN_PROGRESS -> "W trakcie"
        TitleStatus.WATCHED -> "Obejrzane"
    }
}

fun dateInPolish(date: String): String {
    val parts = date.split("-")
    if (parts.size != 3) {
        return date
    }
    return "${parts[2]}.${parts[1]}.${parts[0]}"
}

fun monthName(date: String): String {
    val parts = date.split("-")
    if (parts.size != 3) {
        return date
    }
    val month = when (parts[1]) {
        "01" -> "styczeń"
        "02" -> "luty"
        "03" -> "marzec"
        "04" -> "kwiecień"
        "05" -> "maj"
        "06" -> "czerwiec"
        "07" -> "lipiec"
        "08" -> "sierpień"
        "09" -> "wrzesień"
        "10" -> "październik"
        "11" -> "listopad"
        "12" -> "grudzień"
        else -> parts[1]
    }
    return "$month ${parts[0]}"
}
