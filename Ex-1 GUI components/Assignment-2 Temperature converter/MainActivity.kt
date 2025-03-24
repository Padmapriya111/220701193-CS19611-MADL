package com.example.temperatureconverter

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

        val editTextTemperature = findViewById<EditText>(R.id.editTextTemperature)
        val btnToCelsius = findViewById<Button>(R.id.btnToCelsius)
        val btnToFahrenheit = findViewById<Button>(R.id.btnToFahrenheit)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        btnToCelsius.setOnClickListener {
            val input = editTextTemperature.text.toString()
            if (input.isNotEmpty()) {
                val fahrenheit = input.toDouble()
                val celsius = (fahrenheit - 32) * 5 / 9
                textViewResult.text = "Result: $celsius °C"
            } else {
                Toast.makeText(this, "Please enter a temperature", Toast.LENGTH_SHORT).show()
            }
        }

        btnToFahrenheit.setOnClickListener {
            val input = editTextTemperature.text.toString()
            if (input.isNotEmpty()) {
                val celsius = input.toDouble()
                val fahrenheit = (celsius * 9 / 5) + 32
                textViewResult.text = "Result: $fahrenheit °F"
            } else {
                Toast.makeText(this, "Please enter a temperature", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
