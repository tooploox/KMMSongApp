package com.github.wzieba.songapp.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow


class InMemorySelectedSongSourcesRepository : SelectedSongSourcesRepository {

    private val mutableState = MutableStateFlow<Set<SongSource>>(emptySet())

    override val state: Flow<Set<SongSource>> = mutableState

    override fun update(sources: Set<SongSource>) {
        mutableState.value = sources
    }

}
