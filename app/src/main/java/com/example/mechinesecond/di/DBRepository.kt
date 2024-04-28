package com.example.mechinesecond.di

import androidx.lifecycle.LiveData
import com.example.mechinesecond.db.QuizDatabase
import com.example.mechinesecond.db.entity.QuizEntity
import javax.inject.Inject

class DBRepository @Inject constructor(private val appDatabase: QuizDatabase) {

    suspend fun insertQuiz(quiz: QuizEntity) {
         appDatabase.quizDao().insert(quiz)
    }
    suspend fun updateQuiz(quiz: QuizEntity) {
        appDatabase.quizDao().update(quiz)
    }
    fun getAllQuiz(): LiveData<List<QuizEntity>> {
        return appDatabase.quizDao().getQuiz()
    }
    suspend fun deleteQuiz() {
        appDatabase.quizDao().delete()
    }

}