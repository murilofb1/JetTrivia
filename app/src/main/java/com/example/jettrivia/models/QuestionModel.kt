package com.example.jettrivia.models

data class QuestionModel(
    val question: String,
    val category: String,
    val answer: String,
    val choices: List<String>
)
