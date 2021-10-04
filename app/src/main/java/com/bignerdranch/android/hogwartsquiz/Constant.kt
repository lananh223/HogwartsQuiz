package com.bignerdranch.android.hogwartsquiz

import android.os.ParcelFileDescriptor.open
import android.system.Os.open
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.nio.channels.AsynchronousFileChannel.open
import java.nio.channels.AsynchronousServerSocketChannel.open
import java.nio.channels.AsynchronousSocketChannel.open
import java.nio.channels.DatagramChannel.open
import java.nio.channels.FileChannel.open
import java.nio.channels.Pipe.open
import java.nio.charset.Charset

object Constant{

    //Create a constant variables which we required in the result screen.
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1, "What are the three objects used by the three brothers in the story?",
            R.drawable.image_1,
            "Wand, snitch, stone", "Cloak, Map, Snitch",
            "Cloak, Stone, Map", "Cloak, Stone, wand", 4
        )

        questionList.add(que1)

        // 2
        val que2 = Question(
            2, "What does the scar above Dumbledore's left knee look like?",
            R.drawable.image_2,
            "A phoenix", "A map of Hogwarts",
             "The London Underground","A lightning bolt",3
        )

        questionList.add(que2)

        // 3
        val que3 = Question(
            3, "Gillyweed is used when___?",
            R.drawable.image_3,
            "Underwater", "Flying",
            "Retaining knowledge", "Trying to figure out the truth", 1
        )

        questionList.add(que3)

        // 4
        val que4 = Question(
            4, "What does the incantation \"Duro\" do?",
            R.drawable.image_4,
            "Hardens things", "Softens things",
            "Heals broken bones", "Locks doors", 1
        )

        questionList.add(que4)

        // 5
        val que5 = Question(
            5, "Who created the Chamber of Secrets?",
            R.drawable.image_5,
            "Salazar Slytherin", "Godric Gryffindor",
            "Helena Ravenclaw", "Albus Dumbledore", 1
        )

        questionList.add(que5)

        // 6
        val que6 = Question(
            6, "What is spell to heal minor injuries",
            R.drawable.image_6,
            "Epeskey", "Alohomora",
            "Deprimo", "Dissendium", 1
        )

        questionList.add(que6)

        // 7
        val que7 = Question(
            7, "The tears from what magical animal have healing powers?",
            R.drawable.image_7,
            "Giant", "Unicorn",
            "Hipogriff", "Phoenix", 4
        )

        questionList.add(que7)

        // 8
        val que8 = Question(
            8, "What is the incantation for the Unlocking Charm?",
            R.drawable.image_8,
            "Verdimillious Tria", "Alohomora",
            "Fumos", "Aberto", 2
        )

        questionList.add(que8)

        // 9
        val que9 = Question(
            9, "What works as an antidote to most poisons?",
            R.drawable.image_9,
            "Ashwinder Eggs", "Dittany",
            "Bezoars", "Wiggenweld Potion", 3
        )

        questionList.add(que9)

        // 10
        val que10 = Question(
            10, "How many staircases does Hogwarts have?",
            R.drawable.image_10,
            "263", "153",
            "96", "142", 4
        )

        questionList.add(que10)

        return questionList
    }
}