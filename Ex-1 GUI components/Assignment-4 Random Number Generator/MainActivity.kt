package com.example.randomnumbergenerator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editMin = findViewById<EditText>(R.id.editMin)
        val editMax = findViewById<EditText>(R.id.editMax)
        val btnGenerate = findViewById<Button>(R.id.btnGenerate)
        val textResult = findViewById<TextView>(R.id.textResult)

        btnGenerate.setOnClickListener {
            val minText = editMin.text.toString()
            val maxText = editMax.text.toString()

            if (minText.isEmpty() || maxText.isEmpty()) {
                Toast.makeText(this, "Please enter both min and max values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val min = minText.toInt()
            val max = maxText.toInt()

            if (min >= max) {
                Toast.makeText(this, "Max must be greater than Min", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val randomNumber = Random.nextInt(min, max + 1)
            textResult.text = "Random Number: $randomNumber"
        }
    }
}
