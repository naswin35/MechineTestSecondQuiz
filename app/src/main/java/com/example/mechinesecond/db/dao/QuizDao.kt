package com.example.mechinesecond.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mechinesecond.db.entity.QuizEntity


@Dao
interface QuizDao {
    @Insert
    suspend fun insert(quiz: QuizEntity)

    @Update
    suspend fun update(quiz: QuizEntity)

    @Query("DELETE FROM quiz")
    suspend fun delete()

    @Query("SELECT * FROM quiz")
    fun getQuiz() : LiveData<List<QuizEntity>>


}