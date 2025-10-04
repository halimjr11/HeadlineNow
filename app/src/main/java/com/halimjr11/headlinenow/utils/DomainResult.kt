package com.halimjr11.headlinenow.utils

sealed class DomainResult<out T> {
    data class Success<out T>(val data: T) : DomainResult<T>()
    data class Error(val throwable: Throwable) : DomainResult<Nothing>()
    object Loading : DomainResult<Nothing>()
}
