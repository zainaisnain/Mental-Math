package com.example.mentalmath

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_addition.*
import kotlinx.android.synthetic.main.activity_addition.bu0
import kotlinx.android.synthetic.main.activity_addition.bu1
import kotlinx.android.synthetic.main.activity_addition.bu2
import kotlinx.android.synthetic.main.activity_addition.bu3
import kotlinx.android.synthetic.main.activity_addition.bu4
import kotlinx.android.synthetic.main.activity_addition.bu5
import kotlinx.android.synthetic.main.activity_addition.bu6
import kotlinx.android.synthetic.main.activity_addition.bu7
import kotlinx.android.synthetic.main.activity_addition.bu8
import kotlinx.android.synthetic.main.activity_addition.bu9
import kotlinx.android.synthetic.main.activity_addition.editText2
import kotlinx.android.synthetic.main.activity_division.*


class Addition : AppCompatActivity() {

    private var correctAnswer: Int = 0
    private var equation: String = ""
    private var firstnum = (1..30).random()
    private var secondnum = (1..30).random()
    // Stats
    private var num_of_correct = 0
    private var wrong = 0

    //for numberEvent
    var isNewOp = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition)

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        equation = "$firstnum + $secondnum"

        val question = findViewById<TextView>(R.id.editText)
        question.text = equation

        val homeBtn = findViewById<Button>(R.id.home_btn)
        homeBtn.setOnClickListener {
            val home = Intent(this, MainActivity::class.java)
            startActivity(home)
        }

    }
    fun numberEvent(view: View){
        if(isNewOp){
            editText2.setText(" ")
        }
        isNewOp = false
        var butclick = editText2.text.toString()
        val butSelect:Button = view as Button
        when(butSelect.id){
            bu0.id -> {butclick += "0"}
            bu1.id -> {butclick += "1"}
            bu2.id -> {butclick += "2"}
            bu3.id -> {butclick += "3"}
            bu4.id -> {butclick += "4"}
            bu5.id -> {butclick += "5"}
            bu6.id -> {butclick += "6"}
            bu7.id -> {butclick += "7"}
            bu8.id -> {butclick += "8"}
            bu9.id -> {butclick += "9"}
        }
        editText2.setText(butclick)
    }
    fun delEvent(view: View){
        editText2.setText("0")
        isNewOp = true
    }

    fun entEvent(view: View){
        val sum = (firstnum + secondnum).toString()
        val text = editText2.text.toString()
        if (sum == text.trim()){
            val alert = AlertDialog.Builder(this)
            //Title for alert dialog
            alert.setTitle("Mental Math")

            //set message for alert dialog
            alert.setMessage(R.string.diaMessage)

            //performing positive action
            alert.setPositiveButton("Ok"){
                    dialogInterface, which ->
                Toast.makeText(applicationContext,"WOW, You are a math Genius!", Toast.LENGTH_SHORT).show()
                finish()
                startActivity(getIntent())
            }
            val alertDialog: AlertDialog = alert.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }else{

            val alert = AlertDialog.Builder(this)
            //Title for alert dialog
            alert.setTitle("Mental Math")

            //set message for alert dialog
            alert.setMessage(R.string.diaMessage2)

            //performing positive action
            alert.setPositiveButton("Try Again"){
                    dialogInterface, which ->
                Toast.makeText(applicationContext,"Sorry, Please Try Again!", Toast.LENGTH_SHORT).show()
                editText2.setText("0")
                isNewOp = true
            }
            val alertDialog: AlertDialog = alert.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

    }

}