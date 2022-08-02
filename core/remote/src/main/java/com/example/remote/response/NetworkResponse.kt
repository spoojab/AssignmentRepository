package com.example.remote.response

import com.example.remote.response.NetworkResponse.Failure
import com.example.remote.response.NetworkResponse.Success

sealed class NetworkResponse<out T> {
    data class Success<T>(val value: T) : NetworkResponse<T>()
    data class Failure(val cause: Throwable) : NetworkResponse<Nothing>()
}

fun <T> NetworkResponse<T>.getOrNull(): T? = when (this) {
    is Success -> value
    is Failure -> null
}

fun <T> NetworkResponse<T>.getOrThrow(): T = when (this) {
    is Success -> value
    is Failure -> throw cause
}

fun <T> NetworkResponse<T>.toResult(): Result<T> = Result.runCatching { getOrThrow() }

inline fun <T, R> NetworkResponse<T>.map(
    mapper: (T) -> R,
): NetworkResponse<R> = when (this) {
    is Success -> Success(mapper(value))
    is Failure -> this
}

