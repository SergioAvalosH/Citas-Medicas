package com.recyclerview.app_citas_medicas.view.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.activity_register_pacient.*

class RegisterPacient : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_pacient)
        tvPRegistrar.setOnClickListener{
            db.collection("usuarios").document(tvPDNI.text.toString()).set(
                hashMapOf(
                    "DNI" to tvPDNI.text.toString(),
                    "Nombres" to tvPName.text.toString(),
                    "Apellidos" to tvPSurname.text.toString(),
                    "Contraseña" to  tvPPassword.text.toString(),
                    "Tipo" to "Paciente"
                )
            )
            tvPDNI.text.clear()
            tvPName.text.clear()
            tvPSurname.text.clear()
            tvPPassword.text.clear()

        }
        tvVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}