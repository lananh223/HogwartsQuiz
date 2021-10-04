package com.bignerdranch.android.hogwartsquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.core.content.res.ResourcesCompat
import com.bignerdranch.android.hogwartsquiz.databinding.ActivityMainBinding.inflate
import com.bignerdranch.android.hogwartsquiz.databinding.ActivityQuizQuestionBinding
import com.bignerdranch.android.hogwartsquiz.databinding.ActivityResultBinding
import com.bignerdranch.android.hogwartsquiz.databinding.ActivityResultBinding.inflate
import java.lang.reflect.Array.getInt

private lateinit var binding: ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val username = intent.getStringExtra(Constant.USER_NAME)
        binding.userName.text = username

        val totalQuestion = intent.getIntExtra(Constant.TOTAL_QUESTIONS, 0)
        val correctAnswer = intent.getIntExtra(Constant.CORRECT_ANSWERS,0)

        binding.score.text = "Your Score is $correctAnswer out of $totalQuestion!"

        if(correctAnswer < (totalQuestion/2)) {
            binding.gif.setImageResource(R.drawable.sorry_hogwarts)
            binding.result.text = "SORRY!"
        }

        binding.doneButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}