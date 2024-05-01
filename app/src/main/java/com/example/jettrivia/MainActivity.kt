package com.example.jettrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jettrivia.screens.HomeScreen
import com.example.jettrivia.screens.SplashScreen
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
                val state by viewModel.state.collectAsState()
                if (state.isLoading)
                    SplashScreen()
                else
                    HomeScreen(state = state, onEvent = viewModel::onEvent)
            }
        }
    }
}