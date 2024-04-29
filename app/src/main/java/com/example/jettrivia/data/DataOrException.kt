package com.example.jettrivia.data

import java.lang.Exception

data class DataOrException<T, Boolean, E : Exception>(
    val data: T? = null,
    val isLoading: Boolean? = null,
    val exception: E? = null
)
