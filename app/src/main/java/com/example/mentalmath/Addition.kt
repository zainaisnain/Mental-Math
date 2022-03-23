package com.example.mentalmath

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Addition : AppCompatActivity() {

    private var correctAnswer: Int = 0
    private var equation: String = ""
    private var firstnum = 0
    private var secondnum = 0
    // Stats
    private var num_of_correct = 0
    private var wrong = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition)


        firstnum = (1..11).random()
        secondnum = (1..11).random()

        equation = "$firstnum + $secondnum"

        var question = findViewById<TextView>(R.id.question)
        question.text = equation
    }
}