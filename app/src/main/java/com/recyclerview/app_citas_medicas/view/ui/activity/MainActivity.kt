package com.recyclerview.app_citas_medicas.view.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.fragment_edit_paciente_profile.*
import kotlinx.android.synthetic.main.fragment_login_paciente.*
import kotlinx.android.synthetic.main.fragment_registro_paciente.*


class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login_paciente)
        tvIngresar.setOnClickListener {


            if(tvUser.text.toString().equals(db.collection("pacientes").whereEqualTo("DNI", tvUser.text.toString()))
                && tvLPassword.text.toString().equals( db.collection("pacientes").whereEqualTo("Contraseña", tvLPassword.text.toString()))){
                tvUser.text.clear()
                tvLPassword.text.clear()
            } else {
                println("error")
            }

        }
        /*tvPRegistrar.setOnClickListener{
            db.collection("pacientes").document(tvPDNI.text.toString()).set(
                hashMapOf(
                    "DNI" to tvPDNI.text.toString(),
                    "Nombres" to tvPName.text.toString(),
                    "Apellidos" to tvPSurname.text.toString(),
                    "Contraseña" to  tvPPassword.text.toString())
            )
            tvPDNI.text.clear()
            tvPName.text.clear()
            tvPSurname.text.clear()
            tvPPassword.text.clear()
        }*/

    }
}