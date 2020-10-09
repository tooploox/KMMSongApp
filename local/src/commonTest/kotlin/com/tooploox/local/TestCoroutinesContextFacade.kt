package com.tooploox.local

import kotlinx.coroutines.Dispatchers

object TestCoroutinesContextFacade : CoroutinesContextFacade {
    override val io = Dispatchers.Unconfined
    override val main = Dispatchers.Unconfined
    override val default = Dispatchers.Unconfined
}
