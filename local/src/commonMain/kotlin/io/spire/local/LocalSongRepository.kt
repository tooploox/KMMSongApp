package io.spire.local

import com.github.wzieba.songapp.domain.Song
import com.github.wzieba.songapp.domain.SongSource
import com.github.wzieba.songapp.domain.SongsRepository
import kotlinx.coroutines.flow.flow

class LocalSongRepository(
    private val fileProvider: FileProvider
) : SongsRepository {

    override val type = SongSource.LOCAL

    override fun observe() = flow {
        this.emit(listOf(Song(fileProvider.provideFile().toString())))
    }
}
