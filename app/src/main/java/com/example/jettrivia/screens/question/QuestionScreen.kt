package com.example.jettrivia.screens.question

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettrivia.components.DottedDivider
import com.example.jettrivia.components.JetTriviaButton
import com.example.jettrivia.repository.QuestionRepository
import com.example.jettrivia.screens.home.HomeEvents
import com.example.jettrivia.screens.home.HomeState


@Composable
fun QuestionScreen(
    state: HomeState = HomeState(),
    onEvent: (HomeEvents) -> Unit = {}
) {
    //val question = QuestionRepository.defaultList[0]
      val question = state.getCurrentQuestion()!!
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Column {
            QuestionsHeader(
                currentQuestion = state.currentQuestionId,
                totalQuestions = state.getTotalQuestions()
            )
            DottedDivider()
            Text(
                modifier = Modifier.padding(6.dp),
                text = question.question,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                lineHeight = 22.sp
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Choices(
                state = state,
                onItemClick = { onEvent(HomeEvents.SelectAnswer(it)) },
                choices = question.choices
            )
            if (state.correctAnswer)
                JetTriviaButton(onClick = { onEvent(HomeEvents.NextQuestion) }, label = "next")
        }


    }
}

@Preview(showBackground = true)
@Composable
fun PreviewQuestionScreen() {

    QuestionScreen()
}