package com.github.wzieba.songapp.domain

import kotlinx.coroutines.flow.flow

class MockItunesRepository : SongsRepository {

    override val type = SongSource.ITUNES

    override fun observe() = flow {
        this.emit(listOf(Song("Itunes song")))
    }
}