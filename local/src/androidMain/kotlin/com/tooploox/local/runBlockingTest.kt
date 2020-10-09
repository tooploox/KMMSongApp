package com.tooploox.local

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors

actual fun runBlockingTest(block: suspend () -> Unit) = runBlocking(
    Executors.newSingleThreadExecutor().asCoroutineDispatcher()
) { block() }
