package com.recyclerview.app_citas_medicas.view.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.app_citas_medicas.R
import com.recyclerview.app_citas_medicas.view.ui.activity.Cita
import com.recyclerview.app_citas_medicas.view.ui.activity.CrearCitaActivity

class CitasAdapter(private val citaList : ArrayList<Cita>): RecyclerView.Adapter<CitasAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_citas,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = citaList[position]

        holder.especialidad.text = currentitem.Especialidad
        holder.fecha.text = currentitem.Fecha
        holder.hora.text = currentitem.Hora

    }

    override fun getItemCount(): Int {

        return citaList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val especialidad : TextView = itemView.findViewById(R.id.tvEspecialidadCitas)
        val fecha : TextView = itemView.findViewById(R.id.tvFechaCitas)
        val hora : TextView = itemView.findViewById(R.id.tvHoraCitas)

    }
}