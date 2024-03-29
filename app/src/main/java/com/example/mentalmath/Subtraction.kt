package com.example.mentalmath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_addition.*

class Subtraction : AppCompatActivity() {
    private var equation: String = ""
    private var firstnum = (1..20).random()
    private var secondnum = (1..10).random()

    //for the buttons
    var isNewOp = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subtraction)

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        if (firstnum > secondnum){
            equation = "$firstnum - $secondnum"
            editText.setText(equation)
        }else{
            equation = "$secondnum - $firstnum"
            editText.setText(equation)
        }
        val homeBtn = findViewById<Button>(R.id.home_btn)
        homeBtn.setOnClickListener {
            val home = Intent(this, MainActivity::class.java)
            startActivity(home)
        }
        }
    fun numberEvent(view: View){
        if (isNewOp){
            editText2.setText(" ")
        }
        isNewOp = false
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
    fun delEvent(view: View){
        editText2.setText(" ")
        isNewOp = true
    }
    fun entEvent(view: View){
        var sum = 0
        var text = editText2.text.toString()
        if (firstnum > secondnum){
            sum = (firstnum - secondnum)
        }else{
            sum = (secondnum - firstnum)
        }
        if (sum.toString() == text.trim()){
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