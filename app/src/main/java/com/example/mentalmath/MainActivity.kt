package com.example.mentalmath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aboutus_btn = findViewById<Button>(R.id.about_us)
        aboutus_btn.setOnClickListener(){
            val intent = Intent(this, AboutUS::class.java)
            startActivity(intent)
        }

        val addition_btn = findViewById<Button>(R.id.addition_btn)
        addition_btn.setOnClickListener{
            val intent = Intent(this, Addition::class.java)
            startActivity(intent)
        }

        val subtraction_btn = findViewById<Button>(R.id.subtraction_btn)
        subtraction_btn.setOnClickListener{
            val intent = Intent(this, Subtraction::class.java)
            startActivity(intent)
        }

        val multiplication_btn = findViewById<Button>(R.id.multiplication_btn)
        multiplication_btn.setOnClickListener{
            val intent = Intent(this, Multiplication::class.java)
            startActivity(intent)
        }

        val division_btn = findViewById<Button>(R.id.division_btn)
        division_btn.setOnClickListener{

            val alert = AlertDialog.Builder(this)
            //Title for alert dialog
            alert.setTitle("DIVISON MENTAL MATH")

            //set message for alert dialog
            alert.setMessage(R.string.divisionAlert)

            //performing positive action
            alert.setPositiveButton("Ok"){
                    dialogInterface, which ->
                Toast.makeText(applicationContext,"You may now Start!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Division::class.java)
                startActivity(intent)
            }
            val alertDialog: AlertDialog = alert.create()
            alertDialog.setCancelable(false)
            alertDialog.show()

        }

    }
}