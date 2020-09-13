package com.github.wzieba.songapp.domain

import kotlinx.coroutines.flow.Flow

interface SelectedSongSourcesRepository {
    val state: Flow<Set<SongSource>>
    fun update(sources: Set<SongSource>)
}