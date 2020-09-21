package io.spire.local

import com.github.wzieba.songapp.domain.SongsRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.inSet
import org.kodein.di.instance
import org.kodein.di.singleton

val local = DI.Module(name = "local") {

    import(platformSpecificModule)

    bind<SongsRepository>().inSet() with singleton { LocalSongRepository(instance()) }
}
