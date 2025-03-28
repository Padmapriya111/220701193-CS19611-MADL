package com.example.sendsms

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {

    private val PERMISSION_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPhoneNumber: EditText = findViewById(R.id.etPhoneNumber)
        val etMessage: EditText = findViewById(R.id.etMessage)
        val btnSendSMS: Button = findViewById(R.id.btnSendSMS)

        btnSendSMS.setOnClickListener {
            val phoneNumber = etPhoneNumber.text.toString()
            val message = etMessage.text.toString()

            if (phoneNumber.isEmpty() || message.isEmpty()) {
                Toast.makeText(this, "Please enter both phone number and message", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check for SMS permission
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.SEND_SMS), PERMISSION_REQUEST_CODE)
            } else {
                sendSMS(phoneNumber, message)
            }
        }
    }
    private fun sendSMS(phoneNumber: String, message: String) {
        val smsIntent = Intent(Intent.ACTION_VIEW)
        smsIntent.data = Uri.parse("sms:$phoneNumber")
        smsIntent.putExtra("sms_body", message)
        startActivity(smsIntent)
    }



    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted. Try sending SMS again.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
