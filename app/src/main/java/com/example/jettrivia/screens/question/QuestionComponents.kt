package com.example.jettrivia.screens.question

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettrivia.components.JetTriviaRadioButton
import com.example.jettrivia.repository.QuestionRepository
import com.example.jettrivia.screens.home.HomeState
import com.example.jettrivia.ui.theme.JetTriviaColors
import com.example.jettrivia.ui.theme.QuestionsHeaderSpan1
import com.example.jettrivia.ui.theme.QuestionsHeaderSpan2

@Composable
fun Choices(
    modifier: Modifier = Modifier,
    state: HomeState,
    onItemClick: (Int) -> Unit,
    choices: List<String>
) {
    Column(modifier = modifier.fillMaxWidth()) {
        choices.forEachIndexed { index, choice ->
            if (index >= 1) Spacer(modifier = Modifier.padding(2.dp))
            Surface(
                modifier = Modifier.border(
                    width = 5.dp,
                    color = JetTriviaColors.stroke,
                    shape = RoundedCornerShape(15.dp)
                )
            ) {
                JetTriviaRadioButton(
                    isSelected = index == state.selectedChoice,
                    onClick = { onItemClick(index) },
                    text = choice,
                    selectedColor = if (state.correctAnswer) Color.Green.copy(alpha = 0.2f)
                    else Color.Red.copy(alpha = 0.2f)
                )
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ChoicesPreview() {
    Choices(
        state = HomeState(),
        onItemClick = {},
        choices = QuestionRepository.defaultList[0].choices
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeaderPreview() {
    QuestionsHeader(currentQuestion = 1, totalQuestions = 365)
}

@Composable
fun QuestionsHeader(currentQuestion: Int, totalQuestions: Int) {
    Text(
        modifier = Modifier.padding(15.dp),
        text = buildAnnotatedString {
            withStyle(QuestionsHeaderSpan1) { append("Question $currentQuestion/") }
            withStyle(QuestionsHeaderSpan2) { append("$totalQuestions") }
        },
    )
}