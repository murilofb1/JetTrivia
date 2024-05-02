package com.example.jettrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.jettrivia.navigation.JetTriviaNavigation
import com.example.jettrivia.screens.home.presentation.SplashScreen
import com.example.jettrivia.ui.theme.JetTriviaColors
import com.example.jettrivia.ui.theme.JetTriviaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTriviaTheme {
                Surface(
                    modifier = Modifier
                        //.background(JetTriviaColors.backGround)
                        .fillMaxSize()
                ) {
                    val viewModel by viewModels<MainViewModel>()
                    val state by viewModel.state.collectAsState()
                    if (state.isLoading) SplashScreen()
                    else JetTriviaNavigation()
                }


            }
        }
    }
}