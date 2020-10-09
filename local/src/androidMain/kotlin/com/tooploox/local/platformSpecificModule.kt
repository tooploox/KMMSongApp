package com.tooploox.local

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

actual val platformSpecificModule: DI.Module = DI.Module("androidLocalModule") {

    bind<PlatformSpecificFileProvider>() with singleton { PlatformSpecificFileProvider(instance()) }

}
