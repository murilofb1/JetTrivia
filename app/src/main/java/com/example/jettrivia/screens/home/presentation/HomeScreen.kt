package com.example.jettrivia.screens.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jettrivia.components.JetTriviaButton
import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.models.QuestionModel
import com.example.jettrivia.navigation.JetTriviaRoutes
import com.example.jettrivia.repository.QuestionRepository
import com.example.jettrivia.screens.home.HomeEvents
import com.example.jettrivia.screens.home.HomeState

@Composable
fun HomeScreen(
    state: HomeState = HomeState(),
    navController: NavController,
    onEvent: (HomeEvents) -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        JetTriviaButton(
            onClick = { navController.navigate(JetTriviaRoutes.QUESTIONS.route) },
            label = "Start Game"
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    HomeScreen(
        state = HomeState(questionsDoe = DataOrException.defaultQuestionDoe),
        navController = rememberNavController()
    ) {}
}