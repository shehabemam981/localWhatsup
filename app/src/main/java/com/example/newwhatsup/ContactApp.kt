package com.example.newwhatsup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.newwhatsup.databinding.ActivityContactAppBinding

class ContactApp() : AppCompatActivity() {
    lateinit var binding:ActivityContactAppBinding
    lateinit var name:String
    lateinit var phone:String
    lateinit var description:String
    lateinit var adapter: ContactAdapter
    var listContact= mutableListOf<DataContact>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        saveButtonClick()
        initRecyclerView()
    }

    private fun initRecyclerView() {
      adapter = ContactAdapter(listContact)
        binding.rvContact.adapter = adapter
        adapter.details=object :ContactAdapter.onContactDetails{
            override fun onClick(contact: DataContact, position: Int) {
                val intent=Intent(this@ContactApp,ContactDetails::class.java)
                intent.putExtra("contact",contact)
                startActivity(intent)
            }

        }

    }


    private fun saveButtonClick() {
        binding.saveBtn.setOnClickListener(View.OnClickListener {
            if (!validateForm()) {
                return@OnClickListener
            }
            name = binding.name.text?.trim().toString()
            phone = binding.phone.text?.trim().toString()
            description = binding.description.text?.trim().toString()
            var contact = DataContact(name, phone, description)
            Log.e("dd",contact.name)
            listContact.add(contact)
            Log.e("dd",listContact.toString())
            adapter.notifyItemInserted(listContact.size-1)
        })
    }

    fun validateForm():Boolean
    {
        name = binding.name.text?.trim().toString()
        phone = binding.phone.text?.trim().toString()
        description = binding.description.text?.trim().toString()
         binding.nameEdit.error =validateName(name)
        binding.phoneEdit.error = validatePhone(phone)
        return validateName(name)==null&&validatePhone(phone)==null

    }
    fun validateName(name :String): String? {
       if(name.isEmpty()){
           return "please enter your name"}
        return null

    }
    fun validatePhone(phone: String):String?{
     if(phone.isEmpty()){
         return "please enter your phone"
     }else if(phone.trim().length<11){
         return "please enter 11 numbers only"
     }
        return null
    }
}