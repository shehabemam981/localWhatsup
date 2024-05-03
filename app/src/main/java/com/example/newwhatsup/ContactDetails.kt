package com.example.newwhatsup

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.IntentCompat
import com.example.newwhatsup.databinding.ActivityContactDetailsBinding

class ContactDetails : AppCompatActivity() {
    lateinit var binding: ActivityContactDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContactDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        personalInformation()
        backButton()
    }
    fun backButton(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun personalInformation() {
        val contact = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(
            "contact", DataContact::class.java
            )
        } else {
          intent.getParcelableExtra<DataContact>("contact")
        }
        binding.personalName.text = contact?.name
        binding.personalPhone.text = contact?.phone
        binding.personalDescription.text = contact?.description
    }
}