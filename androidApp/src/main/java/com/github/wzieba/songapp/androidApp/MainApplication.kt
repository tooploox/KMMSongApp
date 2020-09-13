package com.github.wzieba.songapp.androidApp

import android.app.Application
import com.github.wzieba.songapp.domain.domain
import org.kodein.di.DI
import org.kodein.di.DIAware

class MainApplication : Application(), DIAware {

    override val di = DI.lazy {
        import(domain)
    }
}