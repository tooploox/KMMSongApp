package io.spire.local

import android.content.Context

actual class FileProvider constructor(private val context: Context) {

    actual fun provideFile(): ByteArray {
        return ByteArray(2137)
    }
}