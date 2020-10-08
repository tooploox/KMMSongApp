package io.spire.local

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LocalSong(
    @SerialName("Song Clean")
    val title: String?
)