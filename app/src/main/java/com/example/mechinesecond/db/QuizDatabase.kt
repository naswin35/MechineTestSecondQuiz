package com.example.mechinesecond.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mechinesecond.db.dao.QuizDao
import com.example.mechinesecond.db.entity.Converter
import com.example.mechinesecond.db.entity.QuizEntity


@Database(entities = [QuizEntity::class], version = 1)
@TypeConverters(Converter::class, Converter::class)
abstract class QuizDatabase: RoomDatabase() {

    abstract fun quizDao(): QuizDao

}