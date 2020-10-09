package com.tooploox.local

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocalSong(
    @SerialName("Song Clean") val title: String?,
    @SerialName("ARTIST CLEAN") val artistName: String?,
    @SerialName("Release Year") val releaseYear: String?
)