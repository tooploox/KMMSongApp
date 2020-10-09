package com.github.wzieba.songapp.androidApp

import android.app.Application
import android.content.Context
import com.github.wzieba.songapp.domain.domain
import com.tooploox.local.local
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.bind
import org.kodein.di.singleton

class MainApplication : Application(), DIAware {

    override val di = DI.lazy {
        bind<Context>() with singleton { this@MainApplication }

        import(domain)
        import(local)
    }
}