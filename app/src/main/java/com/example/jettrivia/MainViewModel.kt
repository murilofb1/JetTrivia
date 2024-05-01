package com.example.jettrivia

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettrivia.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: QuestionRepository) : ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()
    private val eventListener = MutableSharedFlow<MainEvents>()

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

    fun onEvent(event: MainEvents) {
        viewModelScope.launch {
            eventListener.emit(event)
        }
    }

    private fun handleEvents() {
        viewModelScope.launch {
            eventListener.collect {
                when (it) {
                    is MainEvents.NextQuestion -> moveToNextQuestion()
                }
            }
        }

    }

    private fun moveToNextQuestion() =
        _state.update { it.copy(currentQuestionId = it.currentQuestionId + 1) }

}