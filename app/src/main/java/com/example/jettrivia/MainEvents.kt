package com.example.jettrivia

sealed interface MainEvents {
    data object NextQuestion : MainEvents
}

