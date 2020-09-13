package com.github.wzieba.songapp.domain

import kotlinx.coroutines.flow.flow

class MockLocalRepository : SongsRepository {

    override val type = SongSource.LOCAL

    override fun observe() = flow {
        this.emit(listOf(Song("local song")))
    }
}


