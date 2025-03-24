package com.example.androidfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load fragments into their respective containers
        loadFragment(StudentBasicDetailsFragment(), R.id.fragmentContainerBasic)
        loadFragment(StudentMarkDetailsFragment(), R.id.fragmentContainerMark)
    }

    private fun loadFragment(fragment: Fragment, containerId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .commit()
    }
}
