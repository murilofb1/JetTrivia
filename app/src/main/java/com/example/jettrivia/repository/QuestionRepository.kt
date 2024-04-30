package com.example.jettrivia.repository

import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.models.QuestionModel
import com.example.jettrivia.network.QuestionApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
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
