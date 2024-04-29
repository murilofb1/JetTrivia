package com.example.jettrivia.network

import com.example.jettrivia.models.QuestionModel
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("world.json")
    suspend fun getAllQuestions(): List<QuestionModel>

}