package com.example.jettrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jettrivia.screens.HomeScreen
import com.example.jettrivia.ui.theme.JetTriviaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTriviaTheme {
                // A surface container using the 'background' color from the theme
                val viewModel by viewModels<MainViewModel>()
                //           HomeScreen()
                val state by viewModel.state.collectAsState()
                TestComposable(state)
            }
        }
    }
}

@Composable
fun TestComposable(state: MainState) {

    if (state.isLoading)
        CircularProgressIndicator()
    else
        Text(text = state.questionList.toString())
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetTriviaTheme {
        HomeScreen()
    }
}