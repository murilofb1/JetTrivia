package com.example.jettrivia.repository

import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.models.QuestionModel
import com.example.jettrivia.network.QuestionApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    companion object {
        val defaultList = listOf(
            QuestionModel(
                "question 1",
                "category",
                "option1",
                listOf("option1", "option2", "option3", "option4")
            ),
            QuestionModel(
                "question 2",
                "category",
                "anwser",
                listOf("option1", "option2", "option3", "option4")
            ),
            QuestionModel(
                "question 3",
                "category",
                "anwser",
                listOf("option1", "option2", "option3", "option4")
            )
        )
    }

    private val listOfQuestions = DataOrException<List<QuestionModel>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<List<QuestionModel>, Boolean, Exception> {
        try {
            listOfQuestions.apply {
                isLoading = true
                data = api.getAllQuestions()
                isLoading = data?.isNotEmpty()
            }
        } catch (e: Exception) {
            listOfQuestions.exception = e
        }
        return listOfQuestions
    }
}
