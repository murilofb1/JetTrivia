package com.example.jettrivia.screens.home

import android.util.Log
import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.models.QuestionModel

data class HomeState(
    val questionsDoe: DataOrException<List<QuestionModel>, Boolean, Exception> =
        DataOrException(emptyList(), false, Exception()),
    val currentQuestionId: Int = 0,
    val isLoading: Boolean = false,
    val selectedChoice: Int? = null,
    val correctAnswer: Boolean = false
) {
    fun getProgress(): Float {
        return (currentQuestionId.toFloat() / getTotalQuestions().toFloat())
    }

    fun getCurrentQuestion(): QuestionModel? =
        questionsDoe.data?.get(currentQuestionId)


    fun getTotalQuestions(): Int =
        questionsDoe.data?.size ?: 0

    fun checkAnswer(index: Int): Boolean {
        var bool = false
        questionsDoe.data?.let {
            with(it[currentQuestionId]) { bool = choices[index] == answer }
        }
        return bool
    }

}