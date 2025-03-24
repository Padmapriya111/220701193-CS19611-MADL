package com.example.simplecalculator

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

        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)
        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        fun calculate(operation: (Double, Double) -> Double, symbol: String) {
            val num1 = editTextNumber1.text.toString()
            val num2 = editTextNumber2.text.toString()

            if (num1.isNotEmpty() && num2.isNotEmpty()) {
                val value1 = num1.toDouble()
                val value2 = num2.toDouble()

                // Prevent division by zero
                if (symbol == "÷" && value2 == 0.0) {
                    textViewResult.text = "Result: Cannot divide by zero"
                    return
                }

                val result = operation(value1, value2)
                textViewResult.text = "Result: $value1 $symbol $value2 = $result"
            } else {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show()
            }
        }

        btnAdd.setOnClickListener { calculate({ a, b -> a + b }, "+") }
        btnSubtract.setOnClickListener { calculate({ a, b -> a - b }, "-") }
        btnMultiply.setOnClickListener { calculate({ a, b -> a * b }, "×") }
        btnDivide.setOnClickListener { calculate({ a, b -> a / b }, "÷") }
    }
}
