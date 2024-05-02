package com.example.jettrivia.screens.home

sealed interface HomeEvents {
    data object NextQuestion : HomeEvents
    data class SelectAnswer(val index: Int) : HomeEvents
}


