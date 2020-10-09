package com.tooploox.local

import com.github.wzieba.songapp.domain.Song
import kotlinx.coroutines.flow.collect
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.asserter

internal class LocalSongRepositoryTest {

    private lateinit var sut: LocalSongRepository

    lateinit var havingJson: String

    @BeforeTest
    fun setUp() {
        sut = LocalSongRepository(
            fileProvider = object : FileProvider {
                override fun provideFile() = havingJson.encodeToByteArray()
            },
            json = songJson,
            contextFacade = TestCoroutinesContextFacade
        )
    }

    @Test
    fun shouldDeserializeSongWhenSourceIsValid() = runBlockingTest {
        havingJson = valid

        sut.observeSongs().collect { collectedSongs ->
            asserter.assertEquals(
                message = "",
                expected = listOf(Song("Caught Up in You", ".38 Special", "1982")),
                actual = collectedSongs,
            )
        }
    }

    @Test
    fun shouldNotDeserializeWhenTitleIsEmpty() = runBlockingTest {
        havingJson = noTitle

        sut.observeSongs().collect { collectedSongs ->
            asserter.assertTrue(
                message = "Songs should be empty",
                actual = collectedSongs.isEmpty()
            )
        }
    }

    @Test
    fun shouldNotDeserializeWhenArtistNameIsEmpty() = runBlockingTest {
        havingJson = noArtistName

        sut.observeSongs().collect { collectedSongs ->
            asserter.assertTrue(
                message = "Songs should be empty",
                actual = collectedSongs.isEmpty()
            )
        }
    }

    @Test
    fun shouldNotDeserializeWhenReleaseYearIsEmpty() = runBlockingTest {
        havingJson = noReleaseYear

        sut.observeSongs().collect { collectedSongs ->
            asserter.assertTrue(
                message = "Songs should be empty",
                actual = collectedSongs.isEmpty()
            )
        }
    }
}
