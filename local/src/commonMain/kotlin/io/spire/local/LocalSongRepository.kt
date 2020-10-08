package io.spire.local

import com.github.wzieba.songapp.domain.Song
import com.github.wzieba.songapp.domain.SongSource
import com.github.wzieba.songapp.domain.SongsRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class LocalSongRepository(
    private val fileProvider: FileProvider,
    private val json: Json
) : SongsRepository {

    override val type = SongSource.LOCAL

    override fun observeSongs() = flow {
        emit(fileProvider.provideFile())
    }.mapLatest { byteArray ->
        val rawJsonString = byteArray.decodeToString()
        val localSongs = json.decodeFromString<List<LocalSong>>(rawJsonString)
        localSongs.mapNotNull { localSong ->
                localSong.title?.let { title ->
                    Song(title)
                }
            }
    }
}
