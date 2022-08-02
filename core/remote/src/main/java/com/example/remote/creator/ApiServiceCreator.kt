package com.example.remote.creator

import com.squareup.moshi.Moshi

interface ApiServiceCreator {
    fun <T> create(
        serviceClass: Class<T>
    ): T
}