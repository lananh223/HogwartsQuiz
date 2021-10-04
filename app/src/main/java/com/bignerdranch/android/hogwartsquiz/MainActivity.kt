package com.bignerdranch.android.hogwartsquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bignerdranch.android.hogwartsquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // hide status bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.startButton.setOnClickListener {
            if (binding.userName.text.toString().isEmpty()) {
                Toast.makeText(
                    this,
                    R.string.input,
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constant.USER_NAME,binding.userName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}