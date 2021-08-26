package com.recyclerview.app_citas_medicas.view.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import com.recyclerview.app_citas_medicas.view.ui.adapter.CitasAdapter
import kotlinx.android.synthetic.main.activity_crear_cita.*

class ManageCitas : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_manage_citas)

        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //val adapter = CitasAdapter()
        //recyclerView.layoutManager = LinearLayoutManager(this)
        /*val adap =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, especialidadesLista)*/
        //recyclerView.adapter = adapter


    }

    /*fun getEspecialidades(): ArrayList<String> {
        val data = db.collection("especialidad").get()
        db.collection("especialidad").get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val cadena = " ${document.getString("Nombre")}"
                    especialidadesLista.add(cadena)
                }
            }
        println(data)
        return especialidadesLista
    }*/
}