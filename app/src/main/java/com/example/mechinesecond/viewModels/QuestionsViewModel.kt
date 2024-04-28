package com.example.mechinesecond.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mechinesecond.db.entity.QuizEntity
import com.example.mechinesecond.di.DBRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val dbRepository: DBRepository): ViewModel() {

    fun insertQuiz(quiz: QuizEntity) {
        viewModelScope.launch {
            dbRepository.insertQuiz(quiz)
        }
    }

    fun updateQuiz(quiz: QuizEntity) {
        viewModelScope.launch {
            dbRepository.updateQuiz(quiz)
        }
    }
    fun getAllArticles() = dbRepository.getAllQuiz()
}