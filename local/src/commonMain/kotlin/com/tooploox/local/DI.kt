package com.tooploox.local

import com.github.wzieba.songapp.domain.SongsRepository
import kotlinx.serialization.json.Json
import org.kodein.di.*

val local = DI.Module(name = "local") {

    import(platformSpecificModule)

    bind<CoroutinesContextFacade>() with provider {
        PlatformSpecificCoroutinesContextFacade()
    }

    bind<SongsRepository>().inSet() with singleton {
        LocalSongRepository(
            instance(),
            instance(),
            instance()
        )
    }

    bind<Json>() with provider {
        songJson
    }
}
