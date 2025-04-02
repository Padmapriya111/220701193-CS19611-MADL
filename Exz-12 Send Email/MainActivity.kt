package com.example.sendemail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmail: EditText = findViewById(R.id.etEmail)
        val etSubject: EditText = findViewById(R.id.etSubject)
        val etMessage: EditText = findViewById(R.id.etMessage)
        val btnSendEmail: Button = findViewById(R.id.btnSendEmail)

        btnSendEmail.setOnClickListener {
            val recipient = etEmail.text.toString().trim()
            val subject = etSubject.text.toString().trim()
            val message = etMessage.text.toString().trim()

            if (recipient.isEmpty() || subject.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                sendEmail(recipient, subject, message)
            }
        }
    }

    private fun sendEmail(email: String, subject: String, message: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:$email")
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }

        try {
            startActivity(Intent.createChooser(intent, "Choose an email client"))
        } catch (e: Exception) {
            Toast.makeText(this, "No email client found", Toast.LENGTH_SHORT).show()
        }
    }
}
