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
import com.recyclerview.app_citas_medicas.view.ui.fragments.LoginAdministradorFragment
import com.recyclerview.app_citas_medicas.view.ui.fragments.LoginPaciente
import kotlinx.android.synthetic.main.fragment_indice.*
import kotlinx.android.synthetic.main.fragment_login_paciente.*
import kotlinx.android.synthetic.main.fragment_registro_paciente.*


class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    lateinit var usuario: EditText
    lateinit var contraseña: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val administrador = tvAAdmin
        val paciente = tvPPaciente

        setContentView(R.layout.fragment_indice)
        administrador.setOnClickListener {
            val fragments = LoginAdministradorFragment()
            val manager = supportFragmentManager
            val transaction= manager.beginTransaction()
            transaction.replace(R.id.fragment_view_indice,fragments)
            transaction.addToBackStack(null)
            transaction.commit()
        }
        paciente.setOnClickListener {
            val fragments = LoginPaciente()
            val manager = supportFragmentManager
            val transaction= manager.beginTransaction()
            transaction.replace(R.id.fragment_view_indice,fragments)
            transaction.addToBackStack(null)
            transaction.commit()

        }

    }
    fun registrar(){
        tvPRegistrar.setOnClickListener{
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
        }
    }

    /*fun ingresarD(Puser:String,Ppassword:String){

        tvIngresar.setOnClickListener {
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

        }
    }*/
}