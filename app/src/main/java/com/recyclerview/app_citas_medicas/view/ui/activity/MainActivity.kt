package com.recyclerview.app_citas_medicas.view.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import android.view.View
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import com.recyclerview.app_citas_medicas.view.ui.fragments.AdminMenu
import com.recyclerview.app_citas_medicas.view.ui.fragments.LoginAdministradorFragment
import com.recyclerview.app_citas_medicas.view.ui.fragments.LoginPaciente
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
                        startActivity(intent)
                    } else {
                        if (tipobd == tipoadmin) {
                            val fragments = AdminMenu()
                            val manager = supportFragmentManager
                            val transaction= manager.beginTransaction()
                            transaction.replace(R.id.login_paciente,fragments)
                            transaction.addToBackStack(null)
                            transaction.commit()
                        }
                    }
                }
            }
        }
        linkRegister.setOnClickListener{
            val intent = Intent(this, RegisterPacient::class.java)
            startActivity(intent)
        }
        /**/
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
        /*tvAAdmin.setOnClickListener {
            val fragments = LoginAdministradorFragment()
            val manager = supportFragmentManager
            val transaction= manager.beginTransaction()
            transaction.replace(R.id.fragment_view_indice,fragments)
            transaction.addToBackStack(null)
            transaction.commit()

        }*/
        /*val fragments = LoginPaciente()
        val manager = supportFragmentManager
        val transaction= manager.beginTransaction()
        tvPPaciente.setOnClickListener {
            transaction.replace(R.id.fragment_view_indice,fragments)
            transaction.addToBackStack(null)
            transaction.commit()

        }*/

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
        /*tvIngresar.setOnClickListener {
            usuario =  findViewById(Puser)
            contraseña =  findViewById(Ppassword)
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

        }*/

    }






}