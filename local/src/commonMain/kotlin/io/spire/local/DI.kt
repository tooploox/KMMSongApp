package io.spire.local

import com.github.wzieba.songapp.domain.SongsRepository
import kotlinx.serialization.json.Json
import org.kodein.di.*

val local = DI.Module(name = "local") {

    import(platformSpecificModule)

    bind<SongsRepository>().inSet() with singleton { LocalSongRepository(instance(), instance()) }

    bind<Json>() with provider {
        Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
    }
}
