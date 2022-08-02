package com.example.util

interface NoInputSuspendingUseCase<out Output> : SuspendingUseCase<Unit, Output> {

    override suspend fun execute(input: Unit) = execute()
    suspend fun execute(): Output
}