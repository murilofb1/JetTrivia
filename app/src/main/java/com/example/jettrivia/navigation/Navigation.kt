package com.example.jettrivia.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jettrivia.MainViewModel
import com.example.jettrivia.screens.home.presentation.HomeScreen
import com.example.jettrivia.screens.question.QuestionScreen

@Composable
fun JetTriviaNavigation() {
    val controller = rememberNavController()
    val viewModel: MainViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()
    NavHost(navController = controller, startDestination = JetTriviaRoutes.HOME.route) {
        composable(JetTriviaRoutes.HOME.route) {
            HomeScreen(state = state, onEvent = viewModel::onEvent, navController = controller)
        }
        composable(JetTriviaRoutes.QUESTIONS.route) {
            QuestionScreen(state = state, onEvent = viewModel::onEvent)
        }
    }
}

enum class JetTriviaRoutes(val route: String) {
    SPLASH("splash"), HOME("home"), QUESTIONS("question")
}