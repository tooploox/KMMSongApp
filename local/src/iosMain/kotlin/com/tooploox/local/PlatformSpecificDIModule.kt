package com.tooploox.local

import org.kodein.di.DI

actual val platformSpecificModule: DI.Module = DI.Module("androidLocalModule") {}
