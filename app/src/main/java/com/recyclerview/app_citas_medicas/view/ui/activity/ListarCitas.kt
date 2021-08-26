package com.recyclerview.app_citas_medicas.view.ui.activity

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import com.recyclerview.app_citas_medicas.view.ui.adapter.CitaAdapter
import kotlinx.android.synthetic.main.activity_crear_cita.*
import kotlinx.android.synthetic.main.list_citas.*

class ListarCitas : AppCompatActivity(){
    val db= Firebase.firestore
    var especialidad=""
    var fecha=""
    var hora=""
    var DNI=""
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_citas)
        db.collection("citas")
            .addSnapshotListener{querySnapshot,error->
                if(error!=null){
                    mensaje(error.message!!)
                    return@addSnapshotListener
                }
                for(document in querySnapshot!!){
                    DNI=" ${document.getString("DNI")}"
                    especialidad="${document.getString("especialidad")}"
                    fecha="${document.getString("fecha")}"
                    hora="${document.getString("hora")}"
                }
                tvDNICitas.text=DNI
                tvEspecialidadCitas.text=especialidad
                tvFechaCitas.text=fecha
                tvHoraCitas.text=hora
            }
    }
    private fun mensaje(s: String) {
        AlertDialog.Builder(this).setTitle("Atencion")
            .setMessage(s)
            .setPositiveButton("OK"){d,i->}
            .show()
    }
}