package com.example.util

interface Mapper<in I, out O> {
    suspend fun map(input: I): O
}