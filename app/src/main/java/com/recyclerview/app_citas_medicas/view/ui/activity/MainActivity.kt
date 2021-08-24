package com.recyclerview.app_citas_medicas.view.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.fragment_login_paciente.*


class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore

    lateinit var usuario: EditText
    lateinit var contraseña: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login_paciente)

        tvIngresar.setOnClickListener {
            usuario =  findViewById(R.id.tvUser)
            contraseña =  findViewById(R.id.tvLPassword)
            var user:String = usuario.text.toString()
            var password:String = contraseña.text.toString()
            var userbd:String = ""
            var passwordbd:String = ""
            db.collection("pacientes").get().addOnSuccessListener { result ->
                    for (documento in result){
                        userbd = documento["DNI"].toString()
                        passwordbd = documento["Contraseña"].toString()
                    }
                    if (user == userbd && password == passwordbd){
                        val intent = Intent( this,PacienteActivity::class.java)
                        startActivity(intent)
                    }

                } .addOnFailureListener{

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