package com.example.mechinesecond.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "quiz")
data class QuizEntity(
    @PrimaryKey(autoGenerate = false) var id: Int = 0,
    var questions : ArrayList<QuestionsEntity> = arrayListOf(),
)

class Converter {
    private val gson = Gson()
    @TypeConverter
    fun fromString(sourceEntity: String): ArrayList<QuestionsEntity> {

        val type = object : TypeToken<ArrayList<QuestionsEntity>>() {}.type
        return gson.fromJson(sourceEntity, type)
    }
    @TypeConverter
    fun fromArray(list: ArrayList<QuestionsEntity>): String {
        return gson.toJson(list)
    }
}
