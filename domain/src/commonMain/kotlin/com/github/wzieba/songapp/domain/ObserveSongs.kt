package com.github.wzieba.songapp.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapConcat

class ObserveSongs(
    private val repositories: Set<SongsRepository>,
    private val selectedSongSourcesRepository: SelectedSongSourcesRepository
) {

    fun invoke(): Flow<List<Song>> = selectedSongSourcesRepository.state
        .flatMapConcat { sources ->
            combine(repositories
                        .filter { sources.contains(it.type) }
                        .map(SongsRepository::observeSongs)) { arrayOfLists ->
                arrayOfLists.flatMap { it }
            }
        }
}
