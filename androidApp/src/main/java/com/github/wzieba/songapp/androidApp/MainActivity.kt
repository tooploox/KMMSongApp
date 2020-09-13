package com.github.wzieba.songapp.androidApp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.wzieba.songapp.domain.ObserveSongs
import com.github.wzieba.songapp.domain.SelectSource
import com.github.wzieba.songapp.domain.SongSource
import kotlinx.coroutines.flow.collect
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.instance

class MainActivity : AppCompatActivity(), DIAware {

    override val di: DI by closestDI()

    val observeSongs: ObserveSongs by instance()
    val selectSource: SelectSource by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)

        lifecycleScope.launchWhenCreated {
            observeSongs.invoke().collect {
                tv.text = it.toString()
            }
        }
        selectSource.invoke(setOf(SongSource.ITUNES, SongSource.LOCAL))
    }
}
