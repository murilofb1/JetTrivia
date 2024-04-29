package com.example.jettrivia.repository

import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.models.QuestionModel
import com.example.jettrivia.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(
    private val api: QuestionApi,
    private val listOfQuestions: DataOrException<List<QuestionModel>, Boolean, Exception>
    = DataOrException()
)
