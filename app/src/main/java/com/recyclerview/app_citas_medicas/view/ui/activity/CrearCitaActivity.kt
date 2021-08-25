package com.recyclerview.app_citas_medicas.view.ui.activity

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.activity_crear_cita.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CrearCitaActivity : AppCompatActivity() {

    val db = Firebase.firestore
    var datalista=ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cita)

        db.collection("especialidad")
            .addSnapshotListener{querySnapshot,error->
                if(error!=null){
                    mensaje(error.message!!)
                    return@addSnapshotListener
                }
                for(document in querySnapshot!!){
                    var cadena=" ${document.getString("Nombre")}"
                    datalista.add(cadena)
                }
                EspSpinner.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datalista)
                }
        }

    private fun mensaje(s: String) {
        AlertDialog.Builder(this).setTitle("Atencion")
            .setMessage(s)
            .setPositiveButton("OK"){d,i->}
            .show()
    }


    // Para el toolbar Crear Citas Medicas
        //val actionBar = supportActionBar
        //actionBar!!.title = "Crear Cita"
        //actionBar.setDisplayHomeAsUpEnabled(true)


        // Mensaje para cuando se cree la cita
        //bntGuardarCita.setOnClickListener{
        //    Toast.makeText(this, "Todavia No se implementa, gay!", Toast.LENGTH_SHORT).show()
        //}

}