package io.spire.local

import android.content.Context

actual class FileProvider constructor(private val context: Context) {

    actual fun provideFile(): ByteArray = context.assets.open("songs-list.json").readBytes()
}
