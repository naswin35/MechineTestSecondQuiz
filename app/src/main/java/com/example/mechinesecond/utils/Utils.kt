package com.example.mechinesecond.utils

import com.example.mechinesecond.R
import com.example.mechinesecond.db.entity.CountriesEntity
import com.example.mechinesecond.db.entity.QuestionsEntity

class Utils {
    val countryFirstArray = ArrayList<QuestionsEntity>()
    val countrySecondArray = ArrayList<QuestionsEntity>()
    val countryThirdArray = ArrayList<QuestionsEntity>()
    val countryFourthArray = ArrayList<QuestionsEntity>()
    val countryFifthArray = ArrayList<QuestionsEntity>()
    val countrySixthArray = ArrayList<QuestionsEntity>()
    val countrySeventhArray = ArrayList<QuestionsEntity>()
    val countryEighthArray = ArrayList<QuestionsEntity>()
    val countryNinthArray = ArrayList<QuestionsEntity>()
    val countryTenthArray = ArrayList<QuestionsEntity>()
    fun dataBaseItems() {
        val countriesFirstOptionOne = CountriesEntity()
        countriesFirstOptionOne.apply {
            this.id = 1
            this.countryName = "Bosnia"
        }
        val countriesFirstOptionTwo = CountriesEntity()
        countriesFirstOptionTwo.apply {
            this.id = 2
            this.countryName = "Mauritania"
        }
        val countriesFirstOptionThree = CountriesEntity()
        countriesFirstOptionThree.apply {
            this.id = 3
            this.countryName = "Chile"
        }
        val countriesFirstOptionFour = CountriesEntity()
        countriesFirstOptionFour.apply {
            this.id = 4
            this.countryName = "New Zealand"
        }
        val firstQuestion = QuestionsEntity()
        firstQuestion.apply {
            this.answerId = 4
            this.countries.add(countriesFirstOptionOne)
            this.countries.add(countriesFirstOptionTwo)
            this.countries.add(countriesFirstOptionThree)
            this.countries.add(countriesFirstOptionFour)
            this.countryCode = "NZ"
            this.image = R.drawable.new_zealand__nz_.toString()
        }
        countryFirstArray.add(firstQuestion)


        /*-----*/
        val countriesSecondOptionOne = CountriesEntity()
        countriesSecondOptionOne.apply {
            this.id = 5
            this.countryName = "Aruba"
        }
        val countriesSecondOptionTwo = CountriesEntity()
        countriesSecondOptionTwo.apply {
            this.id = 6
            this.countryName = "Serbia"
        }
        val countriesSecondOptionThree = CountriesEntity()
        countriesSecondOptionThree.apply {
            this.id = 7
            this.countryName = "Montenegro"
        }
        val countriesSecondOptionFour = CountriesEntity()
        countriesSecondOptionFour.apply {
            this.id = 8
            this.countryName = "Moldova"
        }
        val secondQuestions = QuestionsEntity()
        secondQuestions.apply {
            this.answerId = 5
            this.countries.add(countriesSecondOptionOne)
            this.countries.add(countriesSecondOptionTwo)
            this.countries.add(countriesSecondOptionThree)
            this.countries.add(countriesSecondOptionFour)
            this.countryCode = "AW"
            this.image = R.drawable.aruba.toString()
        }
        countrySecondArray.add(secondQuestions)

        /*-----*/
        val countriesThirdOptionOne = CountriesEntity()
        countriesThirdOptionOne.apply {
            this.id = 8
            this.countryName = "Kenya"
        }
        val countriesThirdOptionTwo = CountriesEntity()
        countriesThirdOptionTwo.apply {
            this.id = 9
            this.countryName = "Montenegro"
        }
        val countriesThirdOptionThree = CountriesEntity()
        countriesThirdOptionThree.apply {
            this.id = 10
            this.countryName = "Ecuador"
        }
        val countriesThirdOptionFour = CountriesEntity()
        countriesThirdOptionFour.apply {
            this.id = 11
            this.countryName = "Bhutan"
        }
        val thirdQuestions = QuestionsEntity()
        thirdQuestions.apply {
            this.answerId = 10
            this.countries.add(countriesThirdOptionOne)
            this.countries.add(countriesThirdOptionTwo)
            this.countries.add(countriesThirdOptionThree)
            this.countries.add(countriesThirdOptionFour)
            this.countryCode = "EC"
            this.image = R.drawable.ecuador__ec_.toString()
        }
        countryThirdArray.add(thirdQuestions)


        /*-----*/
        val countriesFurthOptionOne = CountriesEntity()
        countriesFurthOptionOne.apply {
            this.id = 12
            this.countryName = "Niue"
        }
        val countriesFurthOptionTwo = CountriesEntity()
        countriesFurthOptionTwo.apply {
            this.id = 13
            this.countryName = "Paraguay"
        }
        val countriesFurthOptionThree = CountriesEntity()
        countriesFurthOptionThree.apply {
            this.id = 14
            this.countryName = "Tuvalu"
        }
        val countriesFurthOptionFour = CountriesEntity()
        countriesFurthOptionFour.apply {
            this.id = 15
            this.countryName = "Indonesia"
        }
        val fourthQuestions = QuestionsEntity()
        fourthQuestions.apply {
            this.answerId = 13
            this.countries.add(countriesFurthOptionOne)
            this.countries.add(countriesFurthOptionTwo)
            this.countries.add(countriesFurthOptionThree)
            this.countries.add(countriesFurthOptionFour)
            this.countryCode = "PY"
            this.image = R.drawable.paraguay__py_.toString()
        }
        countryFourthArray.add(fourthQuestions)


        /*-----*/
        val countriesFifthOptionOne = CountriesEntity()
        countriesFifthOptionOne.apply {
            this.id = 16
            this.countryName = "Kyrgyzstan"
        }
        val countriesFifthOptionTwo = CountriesEntity()
        countriesFifthOptionTwo.apply {
            this.id = 17
            this.countryName = "zimbabwe"
        }
        val countriesFifthOptionThree = CountriesEntity()
        countriesFifthOptionThree.apply {
            this.id = 18
            this.countryName = "Saint Lucia"
        }
        val countriesFifthOptionFour = CountriesEntity()
        countriesFifthOptionFour.apply {
            this.id = 19
            this.countryName = "Ireland"
        }
        val fifthQuestions = QuestionsEntity()
        fifthQuestions.apply {
            this.answerId = 16
            this.countries.add(countriesFifthOptionOne)
            this.countries.add(countriesFifthOptionTwo)
            this.countries.add(countriesFifthOptionThree)
            this.countries.add(countriesFifthOptionFour)
            this.countryCode = "KG"
            this.image = R.drawable.kyrgyzstan__kg_
                .toString()
        }
        countryFifthArray.add(fifthQuestions)

        /*-----*/
        val countriesSixthOptionOne = CountriesEntity()
        countriesSixthOptionOne.apply {
            this.id = 17
            this.countryName = "Saint pierre"
        }
        val countriesSixthOptionTwo = CountriesEntity()
        countriesSixthOptionTwo.apply {
            this.id = 18
            this.countryName = "Namibia"
        }
        val countriesSixthOptionThree = CountriesEntity()
        countriesSixthOptionThree.apply {
            this.id = 19
            this.countryName = "Greece"
        }
        val countriesSixthOptionFour = CountriesEntity()
        countriesSixthOptionFour.apply {
            this.id = 20
            this.countryName = "Anguilla"
        }
        val sixthQuestions = QuestionsEntity()
        sixthQuestions.apply {
            this.answerId = 17
            this.countries.add(countriesSixthOptionOne)
            this.countries.add(countriesSixthOptionTwo)
            this.countries.add(countriesSixthOptionThree)
            this.countries.add(countriesSixthOptionFour)
            this.countryCode = "PM"
            this.image = R.drawable.saint_pierre_and_miquelon__pm_
                .toString()
        }
        countrySixthArray.add(fifthQuestions)

        /*-----*/
        val countriesSeventhOptionOne = CountriesEntity()
        countriesSeventhOptionOne.apply {
            this.id = 21
            this.countryName = "Belarus"
        }
        val countriesSeventhOptionTwo = CountriesEntity()
        countriesSeventhOptionTwo.apply {
            this.id = 22
            this.countryName = "Falkland Islands"
        }
        val countriesSeventhOptionThree = CountriesEntity()
        countriesSeventhOptionThree.apply {
            this.id = 23
            this.countryName = "Japan"
        }
        val countriesSeventhOptionFour = CountriesEntity()
        countriesSeventhOptionFour.apply {
            this.id = 24
            this.countryName = "Iraq"
        }
        val seventhQuestions = QuestionsEntity()
        seventhQuestions.apply {
            this.answerId = 23
            this.countries.add(countriesSeventhOptionOne)
            this.countries.add(countriesSeventhOptionTwo)
            this.countries.add(countriesSeventhOptionThree)
            this.countries.add(countriesSeventhOptionFour)
            this.countryCode = "JP"
            this.image = R.drawable.japan__jp_
                .toString()
        }
        countrySeventhArray.add(seventhQuestions)

        /*-----*/
        val countriesEighthOptionOne = CountriesEntity()
        countriesEighthOptionOne.apply {
            this.id = 25
            this.countryName = "Barbados"
        }
        val countriesEighthOptionTwo = CountriesEntity()
        countriesEighthOptionTwo.apply {
            this.id = 26
            this.countryName = "Italy"
        }
        val countriesEighthOptionThree = CountriesEntity()
        countriesEighthOptionThree.apply {
            this.id = 27
            this.countryName = "Turkmenistan"
        }
        val countriesEighthOptionFour = CountriesEntity()
        countriesEighthOptionFour.apply {
            this.id = 28
            this.countryName = "Cocos Island"
        }
        val eighthQuestions = QuestionsEntity()
        eighthQuestions.apply {
            this.answerId = 27
            this.countries.add(countriesEighthOptionOne)
            this.countries.add(countriesEighthOptionTwo)
            this.countries.add(countriesEighthOptionThree)
            this.countries.add(countriesEighthOptionFour)
            this.countryCode = "TM"
            this.image = R.drawable.turkmenistan__tm_
                .toString()
        }
        countryEighthArray.add(eighthQuestions)

        /*-----*/
        val countriesNinthOptionOne = CountriesEntity()
        countriesNinthOptionOne.apply {
            this.id = 29
            this.countryName = "Martinique"
        }
        val countriesNinthOptionTwo = CountriesEntity()
        countriesNinthOptionTwo.apply {
            this.id = 30
            this.countryName = "Montenegro"
        }
        val countriesNinthOptionThree = CountriesEntity()
        countriesNinthOptionThree.apply {
            this.id = 31
            this.countryName = "Barbados"
        }
        val countriesNinthOptionFour = CountriesEntity()
        countriesNinthOptionFour.apply {
            this.id = 31
            this.countryName = "Monaco"
        }
        val ninthQuestions = QuestionsEntity()
        ninthQuestions.apply {
            this.answerId = 29
            this.countries.add(countriesNinthOptionOne)
            this.countries.add(countriesNinthOptionTwo)
            this.countries.add(countriesNinthOptionThree)
            this.countries.add(countriesNinthOptionFour)
            this.countryCode = "MQ"
            this.image = R.drawable.martinique__mq_
                .toString()
        }
        countryNinthArray.add(ninthQuestions)

        /*-----*/
        val countriesTenthOptionOne = CountriesEntity()
        countriesTenthOptionOne.apply {
            this.id = 32
            this.countryName = "Germany"
        }
        val countriesTenthOptionTwo = CountriesEntity()
        countriesTenthOptionTwo.apply {
            this.id = 33
            this.countryName = "Dominica"
        }
        val countriesTenthOptionThree = CountriesEntity()
        countriesTenthOptionThree.apply {
            this.id = 34
            this.countryName = "Belize"
        }
        val countriesTenthOptionFour = CountriesEntity()
        countriesTenthOptionFour.apply {
            this.id = 35
            this.countryName = "Tuvalu"
        }
        val tenthQuestions = QuestionsEntity()
        tenthQuestions.apply {
            this.answerId = 34
            this.countries.add(countriesTenthOptionOne)
            this.countries.add(countriesTenthOptionTwo)
            this.countries.add(countriesTenthOptionThree)
            this.countries.add(countriesTenthOptionFour)
            this.countryCode = "BZ"
            this.image = R.drawable.belize__bz_
                .toString()
        }
        countryTenthArray.add(tenthQuestions)
    }
}
