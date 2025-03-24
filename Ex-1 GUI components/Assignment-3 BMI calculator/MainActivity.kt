package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextWeight = findViewById<EditText>(R.id.editTextWeight)
        val editTextHeight = findViewById<EditText>(R.id.editTextHeight)
        val btnCalculateBMI = findViewById<Button>(R.id.btnCalculateBMI)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        btnCalculateBMI.setOnClickListener {
            val weightStr = editTextWeight.text.toString()
            val heightStr = editTextHeight.text.toString()

            if (weightStr.isNotEmpty() && heightStr.isNotEmpty()) {
                val weight = weightStr.toDouble()
                val height = heightStr.toDouble()

                if (height > 0) {
                    val bmi = weight / (height * height)
                    val bmiCategory = when {
                        bmi < 18.5 -> "Underweight"
                        bmi < 24.9 -> "Normal weight"
                        bmi < 29.9 -> "Overweight"
                        else -> "Obese"
                    }

                    textViewResult.text = "BMI: %.2f (%s)".format(bmi, bmiCategory)
                } else {
                    Toast.makeText(this, "Height must be greater than 0", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter both weight and height", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
