package com.example.util

interface SuspendingUseCase<in Input, out Output> {
    suspend fun execute(input: Input): Output
}