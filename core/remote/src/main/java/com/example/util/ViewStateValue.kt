package com.example.util
/**
 * Sealed interface of States which could hold data as per state.
 */
sealed interface ViewStateValue<out T> {
    object Idle : ViewStateValue<Nothing>
    object Loading : ViewStateValue<Nothing>
    data class Success<T>(val value: T) : ViewStateValue<T>
    data class Failure(val throwable: Throwable) : ViewStateValue<Nothing>

    operator fun invoke() = (this as? Success<T>)?.value
}

inline fun <T> ViewStateValue<T>.onSuccess(block: (T) -> Unit) = also {
    (it as? ViewStateValue.Success)?.value?.let(block)
}

inline fun <T> ViewStateValue<T>.onFailure(block: (Throwable) -> Unit) = also {
    (it as? ViewStateValue.Failure)?.throwable?.let(block)
}

inline fun <T, R> ViewStateValue<T>.map(block: (T) -> R): ViewStateValue<R> = when (this) {
    is ViewStateValue.Success<T> -> ViewStateValue.Success(block(value))
    is ViewStateValue.Failure -> ViewStateValue.Failure(throwable)
    ViewStateValue.Idle -> ViewStateValue.Idle
    ViewStateValue.Loading -> ViewStateValue.Loading
}
