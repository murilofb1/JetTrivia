package com.example.jettrivia.data

import com.example.jettrivia.models.QuestionModel
import java.lang.Exception

data class DataOrException<T, Boolean, E : Exception>(
    var data: T? = null,
    var isLoading: Boolean? = null,
    var exception: E? = null
) {
    companion object {
        val defaultQuestionDoe = DataOrException<List<QuestionModel>, Boolean, Exception>(
            listOf(
                QuestionModel(
                    question = "Question",
                    category = "Category",
                    answer = "Minha Resposta",
                    choices = listOf("Teste", "Minha Resposta", "Falso")
                )
            ))
    }
}
