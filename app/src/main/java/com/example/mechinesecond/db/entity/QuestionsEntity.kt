package com.example.mechinesecond.db.entity


data class QuestionsEntity (
  var answerId    : Int? = 0,
  var countries   : ArrayList<CountriesEntity> = arrayListOf(),
  var countryCode : String?= "",
  var image : String?= "",
  var answerStatus : Boolean?= false

)