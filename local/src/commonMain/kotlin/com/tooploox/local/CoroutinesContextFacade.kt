package com.tooploox.local

import kotlin.coroutines.CoroutineContext

interface CoroutinesContextFacade {
    val io: CoroutineContext
    val main: CoroutineContext
    val default: CoroutineContext
}

expect class PlatformSpecificCoroutinesContextFacade constructor() : CoroutinesContextFacade
