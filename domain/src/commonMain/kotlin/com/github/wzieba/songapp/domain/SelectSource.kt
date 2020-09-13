package com.github.wzieba.songapp.domain

class SelectSource(
    private val selectedSongSourcesRepository: SelectedSongSourcesRepository
) {
    fun invoke(sources: Set<SongSource>) {
        selectedSongSourcesRepository.update(sources)
    }
}