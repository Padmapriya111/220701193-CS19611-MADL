package com.example.formvalidation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.reflect.KProperty1


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUserName:EditText=findViewById(R.id.etUserName)
        val etPinNumber: EditText=findViewById(R.id.etPinNumber)
        val btLogin: Button =findViewById(R.id.btLogin)
        val btClear:Button=findViewById(R.id.btClear)

        btLogin.setOnClickListener {
            val userName=etUserName.text.toString().trim()
            val pinNumber=etPinNumber.text.toString().trim()

            if(userName.isEmpty()|| pinNumber.isEmpty())
            {
                Toast.makeText(this,"All values are mandatory",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(!userName.matches(Regex("^[a-zA-Z]+$")))
            {
                Toast.makeText(this,"Invalid user name..",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if(!pinNumber.matches(Regex("^[0-9]{4}$")))
            {
                Toast.makeText(this,"Tnvalid pin number...",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        btClear.setOnClickListener {

            etUserName.text.clear()
            etPinNumber.text.clear()
        }
    }
}
