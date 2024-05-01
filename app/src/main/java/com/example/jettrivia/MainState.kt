package com.example.jettrivia

import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.models.QuestionModel

data class MainState(
    val questionsDoe: DataOrException<List<QuestionModel>, Boolean, Exception> =
        DataOrException(emptyList(), false, Exception()),
    val currentQuestionId: Int = 0,
    val isLoading: Boolean = false
) {
    fun getCurrentQuestion(): QuestionModel? {
        return questionsDoe.data?.get(currentQuestionId)
    }

}