package com.example.mentalmath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_addition.*



class Multiplication : AppCompatActivity() {
    private var equation: String = ""
    private var firstnum = (1..500).random()
    private var secondnum = (1..500).random()

    //for the buttons
    var isnewOp = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiplication)

        equation = "$firstnum" + " * " + "$secondnum"

        editText.setText(equation)
    }
    fun numberEvent(view: View){
        if (isnewOp){
            editText2.setText(" ")
        }
        isnewOp = false
        var butClick = editText2.text.toString()
        var butSelect : Button = view as Button
        when(butSelect.id){
            bu0.id -> {butClick += "0"}
            bu1.id -> {butClick += "1"}
            bu2.id -> {butClick += "2"}
            bu3.id -> {butClick += "3"}
            bu4.id -> {butClick += "4"}
            bu5.id -> {butClick += "5"}
            bu6.id -> {butClick += "6"}
            bu7.id -> {butClick += "7"}
            bu8.id -> {butClick += "8"}
            bu9.id -> {butClick += "9"}
        }
        editText2.setText(butClick)
    }
    fun delEvent(view:View){
        editText2.setText(" ")
        isnewOp = true
    }
    fun entEvent(view:View){
        var product = (firstnum * secondnum).toString()
        var answer = editText2.text.toString()
        if (product == answer.trim()){
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
                isnewOp = true
            }
            val alertDialog: AlertDialog = alert.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }
}