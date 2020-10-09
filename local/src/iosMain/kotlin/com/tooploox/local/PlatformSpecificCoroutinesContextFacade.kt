package com.tooploox.local

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

//To improve: https://github.com/Kotlin/kotlinx.coroutines/blob/native-mt/kotlin-native-sharing.md
actual class PlatformSpecificCoroutinesContextFacade : CoroutinesContextFacade {
    override val io: CoroutineContext = Dispatchers.Main
    override val main: CoroutineContext = Dispatchers.Main
    override val default: CoroutineContext = Dispatchers.Default
}