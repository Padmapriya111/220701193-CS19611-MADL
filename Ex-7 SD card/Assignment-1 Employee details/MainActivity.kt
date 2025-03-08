package com.example.employeedetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.employeedetails.R
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val etEmpId : EditText = findViewById(R.id.etEmpId)
        val etName : EditText = findViewById(R.id.etName)
        val etSalary : EditText = findViewById(R.id.etSalary)
        val btSave : Button = findViewById(R.id.btSave)
        val btLoad : Button = findViewById(R.id.btLoad)

        btSave.setOnClickListener {
            val empId = etEmpId.text.toString()
            val name = etName.text.toString()
            val salary = etSalary.text.toString()
            val file = File(getExternalFilesDir(null ),"employee.txt")
            val writer = FileWriter(file)
            writer.write("$empId\n$name\n$salary")
            writer.close()
            Toast.makeText(this , "saved successfully ! ", Toast.LENGTH_LONG).show()
            etEmpId.text.clear()
            etName.text.clear()
            etSalary.text.clear()
        }

        btLoad.setOnClickListener {
            val file = File(getExternalFilesDir(null),"employee.txt")
            val reader = BufferedReader(FileReader(file))
            val empId = reader.readLine()
            val name = reader.readLine()
            val salary = reader.readLine()
            reader.close()
            Toast.makeText(this,"load successfully!", Toast.LENGTH_LONG).show()
            etEmpId.setText(empId)
            etName.setText(name)
            etSalary.setText(salary)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
