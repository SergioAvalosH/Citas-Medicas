package com.recyclerview.app_citas_medicas.view.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.activity_crear_cita.*

class CrearCitaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cita)

        // Para el toolbar Crear Citas Medicas
        val actionBar = supportActionBar
        actionBar!!.title = "Crear Cita"
        actionBar.setDisplayHomeAsUpEnabled(true)


        // Mensaje para cuando se cree la cita
        bntGuardarCita.setOnClickListener{
            Toast.makeText(this, "Todavia No se implementa, gay!", Toast.LENGTH_SHORT).show()
        }
    }
}