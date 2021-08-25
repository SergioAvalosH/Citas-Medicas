package com.recyclerview.app_citas_medicas.view.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.app_citas_medicas.R
import com.recyclerview.app_citas_medicas.view.ui.activity.Cita

class CitaAdapter(private val citaList:ArrayList<Cita>): RecyclerView.Adapter<CitaAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaAdapter.MyViewHolder {

        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.list_citas,parent,false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CitaAdapter.MyViewHolder, position: Int) {

        val cita: Cita=citaList[position]
        holder.firstName.text= cita.firstName
        holder.lastName.text= cita.lastName
        holder.age.text= cita.age.toString()
    }

    override fun getItemCount(): Int {
        return citaList.size
    }

    public class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val firstName: TextView =itemView.findViewById(R.id.tvFirstName)
        val lastName: TextView=itemView.findViewById(R.id.tvLastName)
        val age: TextView=itemView.findViewById(R.id.tvAge)
    }
}