package com.example.alertdialogbox

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etText : EditText = findViewById(R.id.etText)
        val btDisplay : Button = findViewById(R.id.btDisplay)
        btDisplay.setOnClickListener{
            val alertDialog =AlertDialog.Builder(this)
                .setTitle("MAD Lab")
                .setMessage(etText.text.toString())
                .setPositiveButton("OK"){ dialog, which ->
                    Toast.makeText(this, "You clicked Ok", Toast.LENGTH_LONG).show()
                }
                .setNegativeButton("Cancel"){dialog, which->
                    Toast.makeText(this, "You clicked cancel", Toast.LENGTH_LONG).show()
                }
                .create()
            alertDialog.show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
