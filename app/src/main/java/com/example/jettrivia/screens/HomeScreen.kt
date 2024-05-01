package com.example.jettrivia.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jettrivia.MainEvents
import com.example.jettrivia.MainState
import com.example.jettrivia.models.QuestionModel
import com.example.jettrivia.repository.QuestionRepository

@Preview
@Composable
fun HomeScreen(state: MainState = MainState(), onEvent: (MainEvents) -> Unit = {}) {
    Column {
        state.getCurrentQuestion()?.let {
            QuestionItem(question = it)
        }
        Button(onClick = { onEvent(MainEvents.NextQuestion) }) {
            Text(text = "NEXT QUESTION")
        }
    }

}


@Composable
fun QuestionsRecycler(list: List<QuestionModel>? = QuestionRepository.defaultList) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(5.dp)
    ) {
        itemsIndexed(list ?: emptyList()) { index, question ->
            list?.let {
                if (index in 0..it.size)
                    Spacer(modifier = Modifier.padding(3.dp))
            }
            QuestionItem(question)
        }
    }
}

@Composable
private fun QuestionItem(question: QuestionModel) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column {
            Text(text = question.question)
            Text(text = question.category)
            question.choices.forEach {
                var selection by remember { mutableStateOf(false) }
                Row(
                    modifier = Modifier
                        .background(Color.Red)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = selection, onClick = { selection = !selection })
                    Text(text = it, color = Color.White)
                }


            }
        }
    }
}