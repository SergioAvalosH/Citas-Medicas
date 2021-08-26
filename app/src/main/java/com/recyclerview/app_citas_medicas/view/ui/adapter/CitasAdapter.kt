package com.recyclerview.app_citas_medicas.view.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import com.recyclerview.app_citas_medicas.view.ui.activity.CrearCitaActivity
import com.recyclerview.app_citas_medicas.view.ui.activity.ManageCitas

class CitasAdapter: RecyclerView.Adapter<CitasAdapter.ViewHolder>() {

    private val list = ArrayList<String>()
    val db = Firebase.firestore

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_citas, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        db.collection("especialidad").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val cadena = " ${document.getString("Nombre")}"
                    list.add(cadena)
                }
                viewHolder.nameEspecialidad.text = list[position]
            }

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
        return list.size
    }
}