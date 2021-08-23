package com.recyclerview.app_citas_medicas.view.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.fragment_registro_paciente.*


class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_registro_paciente)
        tvPRegistrar.setOnClickListener{
            db.collection("pacientes").document(tvPDNI.text.toString()).set(
                hashMapOf("Nombres" to tvPName.text.toString(),
                    "Apellidos" to tvPSurname.text.toString(),
                    "Contraseña" to tvPName.text.toString())
            )


        }
    }
}