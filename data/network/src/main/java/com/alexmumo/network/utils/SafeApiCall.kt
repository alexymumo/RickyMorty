package com.alexmumo.network.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class SafeApiCall {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): Result<T> {
        return withContext(Dispatchers.IO) {
            try {
                Result.success(apiCall.invoke())
            } catch (throwable: Throwable) {
                Result.failure(throwable)
            }
        }
    }
}
