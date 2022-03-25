package com.example.mentalmath

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_addition.*


class Addition : AppCompatActivity() {

    private var correctAnswer: Int = 0
    private var equation: String = ""
    private var firstnum = (1..10).random()
    private var secondnum = (1..10).random()
    // Stats
    private var num_of_correct = 0
    private var wrong = 0

    //for numberEvent
    var isNewOp = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addition)

        equation = "$firstnum + $secondnum"

        var question = findViewById<TextView>(R.id.editText)
        question.text = equation

    }
    fun numberEvent(view: View){
        if(isNewOp){
            editText2.setText(" ")
        }
        isNewOp = false
        var butclick = editText2.text.toString()
        var butSelect:Button = view as Button
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
        if (sum == text){
            val alert = AlertDialog.Builder(this)
            //Title for alert dialog
            alert.setTitle("Mental Math")

            //set message for alert dialog
            alert.setMessage(R.string.diaMessage)

            //performing positive action
            alert.setPositiveButton("Ok"){
                    dialogInterface, which ->
                Toast.makeText(applicationContext,"asdas", Toast.LENGTH_SHORT).show()
            }
            val alertDialog: AlertDialog = alert.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
        if (sum!=text){

            val alert = AlertDialog.Builder(this)
            //Title for alert dialog
            alert.setTitle("$sum " + " $text")

            //set message for alert dialog
            alert.setMessage(R.string.diaMessage2)

            //performing positive action
            alert.setPositiveButton("Ok"){
                    dialogInterface, which ->
                Toast.makeText(applicationContext,"$sum " + " $text", Toast.LENGTH_SHORT).show()
            }
            val alertDialog: AlertDialog = alert.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

    }

}