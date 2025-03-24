package com.example.techloungecheckin_checkout

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var studentCount = 0
    private lateinit var countTextView: TextView
    private lateinit var checkInButton: Button
    private lateinit var checkOutButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTextView = findViewById(R.id.countTextView)
        checkInButton = findViewById(R.id.checkInButton)
        checkOutButton = findViewById(R.id.checkOutButton)

        updateCount()

        checkInButton.setOnClickListener {
            studentCount++
            updateCount()
        }

        checkOutButton.setOnClickListener {
            if (studentCount > 0) {
                studentCount--
            }
            updateCount()
        }
    }

    private fun updateCount() {
        countTextView.text = studentCount.toString()
    }
}
