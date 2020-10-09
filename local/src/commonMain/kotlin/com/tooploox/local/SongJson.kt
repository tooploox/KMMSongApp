package com.tooploox.local

import kotlinx.serialization.json.Json

val songJson by lazy {
    Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
}