package com.github.wzieba.songapp.domain

import kotlinx.coroutines.flow.Flow

interface SongsRepository {
    val type: SongSource
    fun observeSongs(): Flow<List<Song>>
}