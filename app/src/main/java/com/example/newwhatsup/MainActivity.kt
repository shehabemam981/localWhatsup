package com.example.newwhatsup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.newwhatsup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigatetoContact()

    }

    private fun navigatetoContact() {
        Handler(mainLooper).postDelayed(
            Runnable {
                val intent = Intent(this, R.layout.activity_contact_app::class.java)
                startActivity(intent)
                finish()
            }, 2000
        )
    }
}