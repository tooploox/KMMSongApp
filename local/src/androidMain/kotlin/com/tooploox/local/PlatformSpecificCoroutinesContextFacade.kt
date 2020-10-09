package com.tooploox.local

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual class PlatformSpecificCoroutinesContextFacade : CoroutinesContextFacade {
    override val io: CoroutineContext = Dispatchers.IO
    override val main: CoroutineContext = Dispatchers.Main
    override val default: CoroutineContext = Dispatchers.Default
}