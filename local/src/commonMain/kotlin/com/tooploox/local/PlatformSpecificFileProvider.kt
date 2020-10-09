package com.tooploox.local

expect class PlatformSpecificFileProvider : FileProvider{
    override fun provideFile(): ByteArray
}

interface FileProvider {
    fun provideFile(): ByteArray
}