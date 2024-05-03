package com.example.newwhatsup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter (val listContact:List<DataContact>): RecyclerView.Adapter<ContactAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val nameText:TextView = itemView.findViewById(R.id.rvName)
        val phoneText:TextView = itemView.findViewById(R.id.rvPhone)

        fun bind(contact :DataContact){
            nameText.text = contact.name
            phoneText.text = contact.phone

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val  itemView =LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listContact.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val contact = listContact[position]
        holder.bind(contact)
         holder.itemView.setOnClickListener{
             details?.onClick(contact,position)
         }
    }
     interface onContactDetails{
       fun onClick(contact: DataContact,position:Int)
   }
    var details: onContactDetails? = null



}