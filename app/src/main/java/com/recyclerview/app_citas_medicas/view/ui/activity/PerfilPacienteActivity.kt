package com.recyclerview.app_citas_medicas.view.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_home.*

class PerfilPacienteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_paciente)

        // Para el toolbar
        val actionBar = supportActionBar
        actionBar!!.title = "Perfil"
        actionBar.setDisplayHomeAsUpEnabled(true)

        // Pasar el valor del dni
        val dni: String? = intent.getStringExtra("dni")
        tvDniPaciente.text= dni


    }
}