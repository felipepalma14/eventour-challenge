package br.com.felipepalma14.commons.extensions

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

suspend inline fun <R, T> T.runOn(
    dispatcher: CoroutineDispatcher,
    crossinline block: suspend T.() -> R
): Result<R> =
    withContext(dispatcher) {
        try {
            Result.success(block())
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }