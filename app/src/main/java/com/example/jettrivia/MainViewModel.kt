package com.example.jettrivia

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettrivia.repository.QuestionRepository
import com.example.jettrivia.screens.home.HomeEvents
import com.example.jettrivia.screens.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: QuestionRepository) : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()
    private val eventListener = MutableSharedFlow<HomeEvents>()

    init {
        viewModelScope.launch() {
            _state.update { it.copy(isLoading = true) }
            repository.getAllQuestions().let { doe ->
                _state.update { it.copy(questionsDoe = doe) }
            }
            _state.update { it.copy(isLoading = false) }
        }
        handleEvents()
    }

    fun onEvent(event: HomeEvents) {
        viewModelScope.launch {
            eventListener.emit(event)
        }
    }

    private fun handleEvents() {
        viewModelScope.launch {
            eventListener.collect {
                when (it) {
                    is HomeEvents.NextQuestion -> moveToNextQuestion()
                    is HomeEvents.SelectAnswer -> selectAnswer(it.index)
                }
            }
        }

    }

    private fun selectAnswer(index: Int) {
            _state.update { it.copy(selectedChoice = index, correctAnswer = _state.value.checkAnswer(index)) }
    }

    private fun moveToNextQuestion() =
        _state.update {
            it.copy(
                currentQuestionId = it.currentQuestionId + 1,
                selectedChoice = null,
                correctAnswer = false
            )
        }

}