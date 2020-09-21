package com.github.wzieba.songapp.domain

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.inSet
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.setBinding
import org.kodein.di.singleton

val domain = DI.Module(name = "domain") {
    bind<SelectedSongSourcesRepository>() with singleton { InMemorySelectedSongSourcesRepository() }

    bind() from setBinding<SongsRepository>()
    bind<SongsRepository>().inSet() with singleton { MockItunesRepository() }

    bind<ObserveSongs>() with provider { ObserveSongs(instance(), instance()) }
    bind<SelectSource>() with provider { SelectSource(instance()) }
}
