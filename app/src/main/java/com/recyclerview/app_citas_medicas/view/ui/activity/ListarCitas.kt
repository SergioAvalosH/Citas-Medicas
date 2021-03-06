package com.recyclerview.app_citas_medicas.view.ui.activity

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
//import com.recyclerview.app_citas_medicas.view.ui.adapter.CitaAdapter
import kotlinx.android.synthetic.main.activity_crear_cita.*
//import kotlinx.android.synthetic.main.activity_crear_cita.textViewMedico
import kotlinx.android.synthetic.main.list_citas.*

class ListarCitas : AppCompatActivity() {


    val db = Firebase.firestore

    var especialidad=""
    var fecha=""
    var hora=""
    var DNI=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listar)
        val especialidad=findViewById(R.id.tviewEspecialidad) as TextView
        val fecha=findViewById(R.id.tviewFecha) as TextView
        val hora=findViewById(R.id.tviewHora) as TextView
        db.collection("citas")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("existe", "${document.id} => ${document.data}")

                    especialidad.text=document.getString("Especialidad")
                    fecha.text=document.getString("Fecha")
                    hora.text=document.getString("Hora")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("no existe", "Error getting documents.", exception)
            }
        /*db.collection("citas")
            .addSnapshotListener{querySnapshot,error->
                if(error!=null){
                    mensaje(error.message!!)
                    return@addSnapshotListener
                }
                for(document in querySnapshot!!){
                    DNI="${document.getString("DNI")}"
                    especialidad="${document.getString("Especialidad")}"
                    fecha="${document.getString("Fecha")}"
                    hora="${document.getString("Hora")}"
                }
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
    }*/
    }
}