package com.recyclerview.app_citas_medicas.view.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import com.recyclerview.app_citas_medicas.view.ui.fragments.LoginAdministradorFragment
import com.recyclerview.app_citas_medicas.view.ui.fragments.LoginPaciente
import kotlinx.android.synthetic.main.activity_register_pacient.*
import kotlinx.android.synthetic.main.fragment_login_paciente.*


class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    lateinit var usuario: EditText
    lateinit var contraseña: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login_paciente)

        tvIngresar.setOnClickListener {
            usuario = findViewById(R.id.tvUser)
            contraseña = findViewById(R.id.tvLPassword)
            var user: String = usuario.text.toString()
            var password: String = contraseña.text.toString()
            var tipopaciente: String = "Paciente"
            var tipoadmin: String = "Administrador"
            var userbd: String = ""
            var passwordbd: String = ""
            var tipobd: String = ""

            db.collection("usuarios").document(user).get().addOnSuccessListener {
                    userbd = it.get("DNI").toString()
                    passwordbd = it.get("Contraseña").toString()
                    tipobd = it.get("Tipo").toString()
                if (user == userbd && password == passwordbd) {
                    if (tipobd == tipopaciente) {
                        val intent = Intent(this, PacienteActivity::class.java)
                        intent.putExtra("dni",userbd)
                        startActivity(intent)
                        tvPDNI.text.clear()
                        tvPName.text.clear()
                        tvPSurname.text.clear()
                        tvPPassword.text.clear()
                    } else {
                        if (tipobd == tipoadmin) {
                            Toast.makeText(this, "No es un paciente!!! Intente de nuevo", Toast.LENGTH_SHORT).show()
                            /*val intent = Intent(this, AdminMenu::class.java)
                            startActivity(intent)*/
                            tvPDNI.text.clear()
                            tvPName.text.clear()
                            tvPSurname.text.clear()
                            tvPPassword.text.clear()
                        }
                    }
                } else {
                    Toast.makeText(this, "Usuario o Contraseña erronea", Toast.LENGTH_SHORT).show()
                    tvPDNI.text.clear()
                    tvPName.text.clear()
                    tvPSurname.text.clear()
                    tvPPassword.text.clear()
                }
            }
        }
        linkRegister.setOnClickListener{
            val intent = Intent(this, RegisterPacient::class.java)
            startActivity(intent)
        }
    }
}