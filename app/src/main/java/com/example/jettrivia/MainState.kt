package com.example.jettrivia

import com.example.jettrivia.models.QuestionModel

data class MainState(
    val questionList: List<QuestionModel> = emptyList(),
    val isLoading: Boolean = false
) {
}