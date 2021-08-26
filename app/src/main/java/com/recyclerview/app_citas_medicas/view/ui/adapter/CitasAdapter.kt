package com.recyclerview.app_citas_medicas.view.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.recyclerview.app_citas_medicas.R
import com.recyclerview.app_citas_medicas.view.ui.activity.CrearCitaActivity

class CitasAdapter: RecyclerView.Adapter<CitasAdapter.ViewHolder>() {

    private val especialidades = CrearCitaActivity()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_citas, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        /*viewHolder.nameEspecialidad.text = especialidades.getEspecialidad()[position]
        viewHolder.namePatiente.text =*/

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var nameEspecialidad: TextView
        var namePatiente: TextView

        init {
            nameEspecialidad = itemView.findViewById(R.id.tv_name_especialidad)
            namePatiente = itemView.findViewById(R.id.tv_name_patient)
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}