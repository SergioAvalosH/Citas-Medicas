package com.recyclerview.app_citas_medicas.view.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R

class PerfilPacienteActivity : AppCompatActivity() {

    val db = Firebase.firestore
    lateinit var nombres: TextView
    lateinit var apellidos: TextView
    lateinit var dniPaciente: TextView

    private lateinit var editarPerfil: Button
    private lateinit var changePass: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_paciente)

        // Para el toolbar
        val actionBar = supportActionBar
        actionBar!!.title = "Perfil"
        actionBar.setDisplayHomeAsUpEnabled(true)

        // Pasar el valor del dni
        val dni: String? = intent.getStringExtra("dni")

        nombres = findViewById(R.id.tvNombresPaciente)
        apellidos = findViewById(R.id.tvApellidosPaciente)
        dniPaciente = findViewById(R.id.tvDniPaciente)
        dniPaciente.text= dni

        db.collection("usuarios").document(dniPaciente.text.toString()).get().addOnSuccessListener {
            nombres.text = it.get("Nombres") as String?
            apellidos.text = it.get("Apellidos") as String?
        }

        editarPerfil = findViewById(R.id.editarDatosPaciente)
        changePass = findViewById(R.id.editarContraseñaPaciente)

        editarPerfil.setOnClickListener{
            Toast.makeText(this, "No tiene permiso", Toast.LENGTH_SHORT).show()
        }
        changePass.setOnClickListener{
            Toast.makeText(this, "No tiene permiso", Toast.LENGTH_SHORT).show()
        }
    }
}