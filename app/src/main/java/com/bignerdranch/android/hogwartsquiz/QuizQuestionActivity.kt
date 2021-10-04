package com.bignerdranch.android.hogwartsquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bignerdranch.android.hogwartsquiz.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityQuizQuestionBinding
    private var currentPosition = 1
    private var questionList = Constant.getQuestions()
    private var selectedOptionPosition = 0
    private var userCorrectAnswers: Int = 0
    private var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // hide status bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        userName = intent.getStringExtra(Constant.USER_NAME)

        setQuestion()

        binding.optionOne.setOnClickListener(this)
        binding.optionTwo.setOnClickListener(this)
        binding.optionThree.setOnClickListener(this)
        binding.optionFour.setOnClickListener(this)
        binding.submitButton.setOnClickListener(this)
    }

    // Override the implementation OnClick of the class
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option_one -> {
                selectedOptionView(binding.optionOne, 1)
            }
            R.id.option_two -> {
                selectedOptionView(binding.optionTwo, 2)
            }
            R.id.option_three -> {
                selectedOptionView(binding.optionThree, 3)
            }
            R.id.option_four -> {
                selectedOptionView(binding.optionFour, 4)
            }
            R.id.submit_button -> {
                if (selectedOptionPosition == 0) {
                    currentPosition++

                    when {
                        currentPosition <= questionList.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constant.USER_NAME, userName)
                            intent.putExtra(Constant.CORRECT_ANSWERS, userCorrectAnswers)
                            intent.putExtra(Constant.TOTAL_QUESTIONS, questionList.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = questionList[currentPosition - 1]
                    // Check if the answer is wrong
                    if (question.correctAnswer != selectedOptionPosition) {
                        eachQuestionResult(selectedOptionPosition, R.drawable.wrong_option_border)
                    } else {
                        // Answer is correct
                        userCorrectAnswers++
                    }
                    eachQuestionResult(question.correctAnswer, R.drawable.correct_option_border)

                    if(currentPosition < questionList.size){
                        binding.submitButton.text = getString(R.string.next_question)
                    } else {
                        binding.submitButton.text = getString(R.string.finish)
                    }
                    selectedOptionPosition = 0
                }
            }
        }
    }

    private fun setQuestion() {

        defaultOptionView()
        if(currentPosition == questionList.size) {
            binding.submitButton.text = getString(R.string.finish)
        } else {
            binding.submitButton.text = getString(R.string.submit)
        }
        val question = questionList[currentPosition - 1]

        binding.progressBar.progress = currentPosition
        binding.progress.text = "$currentPosition/" + binding.progressBar.max

        binding.question.text = question.question
        binding.image.setImageResource(question.image)

        binding.optionOne.text = question.optionOne
        binding.optionTwo.text = question.optionTwo
        binding.optionThree.text = question.optionThree
        binding.optionFour.text = question.optionFour
    }

    /**
     * A function to set default options view when the new question is loaded
     * or when the answer is reselected.
     */
    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        options.add(0, binding.optionOne)
        options.add(1, binding.optionTwo)
        options.add(2, binding.optionThree)
        options.add(3, binding.optionFour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_border
            )
        }
    }

    /**
     * A function to set the view of selected option view.
     */
    private fun selectedOptionView(textView: TextView, selectedOptionNumber: Int) {
        defaultOptionView()
        selectedOptionPosition = selectedOptionNumber

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_border
        )
    }

    /**
     * A function to give back result right or wrong
     */
    private fun eachQuestionResult(answer: Int, drawbleView: Int) {
        when (answer) {
            1 -> {
                binding.optionOne.background = ContextCompat.getDrawable(
                    this, drawbleView
                )
            }
            2 -> {
                binding.optionTwo.background = ContextCompat.getDrawable(
                    this, drawbleView
                )
            }
            3 -> {
                binding.optionThree.background = ContextCompat.getDrawable(
                    this, drawbleView
                )
            }
            4 -> {
                binding.optionFour.background = ContextCompat.getDrawable(
                    this, drawbleView
                )
            }
        }
    }
}