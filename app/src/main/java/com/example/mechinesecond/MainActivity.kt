package com.example.mechinesecond

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.mechinesecond.db.entity.QuizEntity
import com.example.mechinesecond.utils.Utils
import com.example.mechinesecond.viewModels.QuestionsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: QuestionsViewModel by viewModels()
    private var questionOnScreen = QuizEntity()
    private var question: TextView? = null
    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null
    private var answerStatusFirst: TextView? = null
    private var answerStatusSecond: TextView? = null
    private var answerStatusThird: TextView? = null
    private var answerStatusFourth: TextView? = null
    private var tvSchedule: TextView? = null
    private var tvSave: TextView? = null
    private var etHourFirst: EditText? = null
    private var etHourSecond: EditText? = null
    private var etMinuteFirst: EditText? = null
    private var etMinuteSecond: EditText? = null
    private var etSecondFirst: EditText? = null
    private var etSecondSecond: EditText? = null
    private var tvTimerForGame: TextView? = null
    private var tvScoreBoard: TextView? = null
    private var llScore: LinearLayout? = null
    private var ivFlag: ImageView? = null
    private var clQuestionSection: ConstraintLayout? = null
    private var questionDurationTimer: TextView? = null
    private var clCountDownTimerEntry: ConstraintLayout? = null
    private var launched = false
    private var questionNumberAppInBackground = 0
    private var arrayDbItemPos = 0
    private var timerCurrentSec = 0
    private var gameStarted = false
    private var updateDbValue = false
    private var quizArray = ArrayList<QuizEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        question = findViewById(R.id.question)
        optionOne = findViewById(R.id.first_option)
        optionTwo = findViewById(R.id.second_option)
        optionThree = findViewById(R.id.third_option)
        optionFour = findViewById(R.id.fourth_option)
        etHourFirst = findViewById(R.id.et_hour_first)
        etHourSecond = findViewById(R.id.et_hour_second)
        etMinuteFirst = findViewById(R.id.et_minute_first)
        etMinuteSecond = findViewById(R.id.et_minute_second)
        etSecondFirst = findViewById(R.id.et_second_first)
        etSecondSecond = findViewById(R.id.et_second_second)
        tvTimerForGame = findViewById(R.id.tv_timer_for_game)
        answerStatusFirst = findViewById(R.id.ans_status_first)
        answerStatusSecond = findViewById(R.id.ans_status_second)
        answerStatusThird = findViewById(R.id.ans_status_third)
        answerStatusFourth = findViewById(R.id.ans_status_fourth)
        clQuestionSection = findViewById(R.id.cl_question_section)
        questionDurationTimer = findViewById(R.id.question_duration_timer)
        clCountDownTimerEntry = findViewById(R.id.cl_timer)
        tvScoreBoard = findViewById(R.id.tv_score_board)
        llScore = findViewById(R.id.ll_score)
        ivFlag = findViewById(R.id.iv_flag)
        tvSave = findViewById(R.id.tv_save)
        tvSchedule = findViewById(R.id.tv_schedule)
        val prefs = getPreferences(MODE_PRIVATE)
        val restoredText = prefs.getBoolean(getString(R.string.launched), false)
        if (!restoredText) {
            val utils = Utils()
            utils.dataBaseItems()
            viewModel.insertQuiz(QuizEntity(0,utils.countryFirstArray))
            viewModel.insertQuiz(QuizEntity(1,utils.countrySecondArray))
            viewModel.insertQuiz(QuizEntity(2,utils.countryThirdArray))
            viewModel.insertQuiz(QuizEntity(3,utils.countryFourthArray))
            viewModel.insertQuiz(QuizEntity(4,utils.countryFifthArray))
            viewModel.insertQuiz(QuizEntity(5,utils.countrySixthArray))
            viewModel.insertQuiz(QuizEntity(6,utils.countrySeventhArray))
            viewModel.insertQuiz(QuizEntity(7,utils.countryEighthArray))
            viewModel.insertQuiz(QuizEntity(8,utils.countryNinthArray))
            viewModel.insertQuiz(QuizEntity(9,utils.countryTenthArray))
        }

        etHourFirst?.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (etHourFirst?.text.toString().length === 1) //size as per your requirement
                {
                    etHourSecond?.requestFocus()
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {}
        })

        etHourSecond?.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (etHourSecond?.getText().toString().length === 1) //size as per your requirement
                {
                    etMinuteFirst?.requestFocus()
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {}
        })

        etMinuteFirst?.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (etMinuteFirst?.text.toString().length === 1) //size as per your requirement
                {
                    etMinuteSecond?.requestFocus()
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {}
        })

        etMinuteSecond?.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (etMinuteSecond?.text.toString().length === 1) //size as per your requirement
                {
                    etSecondFirst?.requestFocus()
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {}
        })

        etSecondFirst?.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (etSecondFirst?.text.toString().length === 1) //size as per your requirement
                {
                    etSecondSecond?.requestFocus()
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {}
        })

        tvSave?.setOnClickListener {
            hideKeyboard(this, it)
            var hourTimeFirst =  etHourFirst?.text.toString()
            var hourTimeSecond =  etHourSecond?.text.toString()
            var minuteTimeFirst =  etMinuteFirst?.text.toString()
            var minuteTimeSecond =  etMinuteSecond?.text.toString()
            var secondTimeFirst =  etSecondFirst?.text.toString()
            var secondTimeSecond =  etSecondSecond?.text.toString()

            if(hourTimeFirst == "") {
                hourTimeFirst = "0"
            }
            if(hourTimeSecond == "") {
                hourTimeSecond = "0"
            }
            if(minuteTimeFirst == "") {
                minuteTimeFirst = "0"
            }
            if(minuteTimeSecond == "") {
                minuteTimeSecond = "0"
            }
            if(secondTimeFirst == "") {
                secondTimeFirst = "0"
            }
            if(secondTimeSecond == "") {
                secondTimeSecond = "0"
            }
            visibilityItems()
            val timerToStart = "$hourTimeFirst$hourTimeSecond:$minuteTimeFirst$minuteTimeSecond:$secondTimeFirst$secondTimeSecond"
            val milliseconds = timeToMilliseconds(timerToStart)
            timer(0, getString(R.string.countdowntimer), milliseconds)
        }

    }
    private fun visibilityItems() {
        clCountDownTimerEntry?.visibility = View.GONE
        tvSave?.visibility = View.GONE
        tvTimerForGame?.visibility = View.VISIBLE
    }

    private fun millisecondsToTime(milliseconds: Long): String {
        val seconds = (milliseconds / 1000).toInt()
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val remainingSeconds = seconds % 60

        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds)
    }
    private fun timeToMilliseconds(timeStr: String): Long {
        val (hours, minutes, seconds) = timeStr.split(":").map { it.toInt() }
        return (hours * 3600 + minutes * 60 + seconds) * 1000L
    }
    private fun getData(startingPos: Int) {

        viewModel.getAllArticles().observe(this) {
                if (arrayDbItemPos != quizArray.size - 1) {
                    if (quizArray.isEmpty()) {
                        quizArray.addAll(it)
                    }
                    launched = true
                    val editor = getPreferences(MODE_PRIVATE).edit()
                    editor.putBoolean(getString(R.string.launched), launched)
                    editor.apply()
                }

                lifecycleScope.launch {
                    for (i in startingPos..<quizArray.size) {
                        timer(i, "", 30000)
                        arrayDbItemPos = i
                        if(updateDbValue){
                            clCountDownTimerEntry?.visibility = View.VISIBLE
                            tvSave?.visibility = View.VISIBLE
                            tvSchedule?.visibility = View.VISIBLE
                            updateDbValue = false
                        } else {
                            clQuestionSection?.visibility = View.VISIBLE
                            tvTimerForGame?.visibility = View.GONE
                            tvSchedule?.visibility = View.GONE
                            clCountDownTimerEntry?.visibility = View.GONE
                            tvSave?.visibility = View.GONE
                        }
                        questionOnScreen = quizArray[i]
                        for (j in quizArray[i].questions.indices) {

                            optionOne?.setBackgroundResource(R.drawable.bg_ash_with_rounded_black_boarder)
                            optionTwo?.setBackgroundResource(R.drawable.bg_ash_with_rounded_black_boarder)
                            optionThree?.setBackgroundResource(R.drawable.bg_ash_with_rounded_black_boarder)
                            optionFour?.setBackgroundResource(R.drawable.bg_ash_with_rounded_black_boarder)
                            answerStatusFirst?.visibility = View.GONE
                            answerStatusSecond?.visibility = View.GONE
                            answerStatusThird?.visibility = View.GONE
                            answerStatusFourth?.visibility = View.GONE
                            optionOne?.text =
                                quizArray[i].questions[j].countries[0].countryName
                            optionTwo?.text =
                                quizArray[i].questions[j].countries[1].countryName
                            optionThree?.text =
                                quizArray[i].questions[j].countries[2].countryName
                            optionFour?.text =
                                quizArray[i].questions[j].countries[3].countryName
                            ivFlag?.let { it1 ->
                                Glide.with(applicationContext)
                                    .load(questionOnScreen.questions[j].image?.let { it2 ->
                                        Integer.valueOf(
                                            it2
                                        )
                                    })
                                    .into(it1)
                            }
                            updateKey(j, 0)
                            updateKey(j, 1)
                            updateKey(j, 2)
                            updateKey(j, 3)

                            optionOne?.setOnClickListener {
                                answerStatusFirst?.visibility = View.VISIBLE
                                if (quizArray[i].questions[j].answerId == quizArray[i].questions[j].countries[0].id) {
                                    quizArray[i].questions[j].answerStatus = true
                                    optionOne?.setBackgroundResource(R.drawable.bg_ash_with_rounded_green)
                                    answerStatusFirst?.text = getString(R.string.correct)
                                    answerStatusFirst?.setTextColor(getColor(R.color.green))
                                } else {
                                    optionOne?.setBackgroundResource(R.drawable.bg_ash_with_rounded_orange)
                                    answerStatusFirst?.setTextColor(getColor(R.color.colorAccent))
                                    answerStatusFirst?.text = getString(R.string.wrong)
                                }
                            }
                            optionTwo?.setOnClickListener {
                                answerStatusSecond?.visibility = View.VISIBLE
                                if (quizArray[i].questions[j].answerId == quizArray[i].questions[j].countries[1].id) {
                                    quizArray[i].questions[j].answerStatus = true
                                    optionTwo?.setBackgroundResource(R.drawable.bg_ash_with_rounded_green)
                                    answerStatusSecond?.text = getString(R.string.correct)
                                    answerStatusSecond?.setTextColor(getColor(R.color.green))
                                } else {
                                    optionTwo?.setBackgroundResource(R.drawable.bg_ash_with_rounded_orange)
                                    answerStatusSecond?.setTextColor(getColor(R.color.colorAccent))
                                    answerStatusSecond?.text = getString(R.string.wrong)
                                }
                            }
                            optionThree?.setOnClickListener {
                                answerStatusThird?.visibility = View.VISIBLE
                                if (quizArray[i].questions[j].answerId == quizArray[i].questions[j].countries[2].id) {
                                    quizArray[i].questions[j].answerStatus = true
                                    optionThree?.setBackgroundResource(R.drawable.bg_ash_with_rounded_green)
                                    answerStatusThird?.text = getString(R.string.correct)
                                    answerStatusThird?.setTextColor(getColor(R.color.green))
                                } else {
                                    optionThree?.setBackgroundResource(R.drawable.bg_ash_with_rounded_orange)
                                    answerStatusThird?.setTextColor(getColor(R.color.colorAccent))
                                    answerStatusThird?.text = getString(R.string.wrong)
                                }
                            }
                            optionFour?.setOnClickListener {
                                answerStatusFourth?.visibility = View.VISIBLE
                                if (quizArray[i].questions[j].answerId == quizArray[i].questions[j].countries[3].id) {
                                    quizArray[i].questions[j].answerStatus = true
                                    optionFour?.setBackgroundResource(R.drawable.bg_ash_with_rounded_green)
                                    answerStatusFourth?.text = getString(R.string.correct)
                                    answerStatusFourth?.setTextColor(getColor(R.color.green))
                                } else {
                                    optionFour?.setBackgroundResource(R.drawable.bg_ash_with_rounded_orange)
                                    answerStatusFourth?.setTextColor(getColor(R.color.colorAccent))
                                    answerStatusFourth?.text = getString(R.string.wrong)
                                }
                            }
                        }
                        delay(30000)
                    }
                }
        }
    }

    private fun updateKey(j:Int, countryKey:Int) {
        if( (questionOnScreen.questions[j].answerStatus == true) && (questionOnScreen.questions[j].answerId ==
                    questionOnScreen.questions[j].countries[countryKey].id)
        ) {
            ivFlag?.let {
                Glide.with(this)
                    .load(questionOnScreen.questions[j].image?.let { it1 -> Integer.valueOf(it1) })
                    .into(it)
            }
            when(countryKey) {
                0 ->  {
                    answerStatusFirst?.visibility = View.VISIBLE
                    optionOne?.setBackgroundResource(R.drawable.bg_ash_with_rounded_green)
                    answerStatusFirst?.text = getString(R.string.correct)
                    answerStatusFirst?.setTextColor(getColor(R.color.green))
                }
                1 ->  {
                    answerStatusSecond?.visibility = View.VISIBLE
                    optionTwo?.setBackgroundResource(R.drawable.bg_ash_with_rounded_green)
                    answerStatusSecond?.text = getString(R.string.correct)
                    answerStatusSecond?.setTextColor(getColor(R.color.green))
                }
                2 ->  {
                    answerStatusThird?.visibility = View.VISIBLE
                    optionThree?.setBackgroundResource(R.drawable.bg_ash_with_rounded_green)
                    answerStatusThird?.text = getString(R.string.correct)
                    answerStatusThird?.setTextColor(getColor(R.color.green))
                }
                3 ->  {
                    answerStatusFourth?.visibility = View.VISIBLE
                    optionFour?.setBackgroundResource(R.drawable.bg_ash_with_rounded_green)
                    answerStatusFourth?.text = getString(R.string.correct)
                    answerStatusFourth?.setTextColor(getColor(R.color.green))
                }
            }

        }
    }
    private fun timer(i: Int, from: String, time: Long) {

        object : CountDownTimer(time, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                if(from != getString(R.string.countdowntimer)) {
                    timerCurrentSec = (millisUntilFinished / 1000).toInt()
                    questionDurationTimer?.visibility = View.VISIBLE
                    clCountDownTimerEntry?.visibility = View.GONE
                    questionDurationTimer?.text =  (millisUntilFinished / 1000).toString()

                } else {
                    tvSchedule?.text = getString(R.string.will_start_in)
                    tvTimerForGame?.text = millisecondsToTime(millisUntilFinished)
                }
            }

            override fun onFinish() {
                if(from != getString(R.string.countdowntimer)) {
                    if (i == quizArray.size - 1) {
                        var totalSum = 0
                        for (item in quizArray) {
                            for (question in item.questions) {
                                if (question.answerStatus == true) {
                                    totalSum += 1
                                }
                            }
                        }
                        llScore?.visibility = View.VISIBLE
                        clQuestionSection?.visibility = View.GONE
                        tvScoreBoard?.text = "$totalSum/10"
                    }
                } else {
                    tvTimerForGame?.visibility = View.GONE
                    gameStarted = true
                    val currentTime: Date = Calendar.getInstance().time
                    val prefs = getPreferences(MODE_PRIVATE)
                    val editor = prefs.edit()
                    if ((prefs.getString(getString(R.string.gamestartedtime), ""))?.isEmpty() == true) {
                        editor.putString(getString(R.string.gamestartedtime), currentTime.toString())
                        editor.putBoolean(getString(R.string.gamestarted), gameStarted)
                    }
                    editor.apply()
                    getData(0)
                }
            }
        }.start()
    }

    override fun onPause() {
        super.onPause()
        val currentTime: Date = Calendar.getInstance().time
        val editor = getPreferences(MODE_PRIVATE).edit()
        editor.putString(getString(R.string.timeatappinbackground), currentTime.toString())
        editor.apply()
        for (item in quizArray) {
            viewModel.updateQuiz(item)
        }
        if((arrayDbItemPos == quizArray.size-1) && timerCurrentSec == 0) {
            updateDb()
        }
    }
    private fun updateDb() {
        gameStarted = false
        val editor = getPreferences(MODE_PRIVATE).edit()
        editor.putBoolean(getString(R.string.gamestarted), gameStarted)
        editor.putString(getString(R.string.gamestartedtime), "")
        editor.apply()
        for (item in quizArray) {
            for(questions in item.questions) {
                if(questions.answerStatus == true) {
                    questions.answerStatus = false
                }
            }
            viewModel.updateQuiz(item)
        }
    }

    override fun onResume() {
        super.onResume()
        val prefs = getPreferences(MODE_PRIVATE)
        val currentTime: Date? = Calendar.getInstance().time
        var elapsedTimeWhenAppInBackground: Long? = null
        val gameStartedTime = prefs.getString(getString(R.string.gamestartedtime), "")
        if (gameStartedTime != "") {
            val format: DateFormat = SimpleDateFormat("E MMM dd HH:mm:ss 'GMT'Z yyyy", Locale.ENGLISH)
            val dateFormat: Date? = gameStartedTime?.let { format.parse(it) }
            elapsedTimeWhenAppInBackground = dateFormat?.time?.let { currentTime?.time?.minus(it) }
        }
        val gamesStarted = prefs.getBoolean(getString(R.string.gamestarted), false)
        if (gamesStarted) {
            elapsedTimeWhenAppInBackground?.let {
                 questionNumberAppInBackground =  (it/30000).toInt()
            }
            if(questionNumberAppInBackground <= 9) {
                getData(questionNumberAppInBackground)
            } else {
                updateDbValue = true
                llScore?.visibility = View.GONE
                updateDb()
            }
        } else {
            clCountDownTimerEntry?.visibility = View.VISIBLE
            tvSchedule?.visibility = View.VISIBLE
        }
    }

    private fun hideKeyboard(context: Context?, view: View) {
        val imm: InputMethodManager =
            context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
