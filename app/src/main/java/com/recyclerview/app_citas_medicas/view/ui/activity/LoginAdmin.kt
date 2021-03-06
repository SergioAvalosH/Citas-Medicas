package com.recyclerview.app_citas_medicas.view.ui.activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.activity_login_admin.*
import kotlinx.android.synthetic.main.activity_register_pacient.*
import kotlinx.android.synthetic.main.fragment_login_paciente.*
class LoginAdmin : AppCompatActivity() {
    val db = Firebase.firestore
    lateinit var usuario: EditText
    lateinit var contraseña: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_admin)
        IngresarA.setOnClickListener {
            usuario = findViewById(R.id.tvAUser)
            contraseña = findViewById(R.id.tvAPassword)
            var user: String = usuario.text.toString()
            var password: String = contraseña.text.toString()
            var tipopaciente: String = "Paciente"
            var tipoadmin: String = "Administrador"
            var userbd: String = ""
            var passwordbd: String = ""
            var tipobd: String = ""
            if(user != "" && password != ""){
                db.collection("usuarios").document(user).get().addOnSuccessListener {
                    userbd = it.get("DNI").toString()
                    passwordbd = it.get("Contraseña").toString()
                    tipobd = it.get("Tipo").toString()
                    if (user == userbd && password == passwordbd) {
                        if (tipobd == tipoadmin) {
                            //val intent = Intent(this, AdminMenu::class.java)
                            startActivity(intent)
                        } else {
                            if (tipobd == tipopaciente) {
                                Toast.makeText(this, " Los Pacientes no tienen Acceso ", Toast.LENGTH_SHORT).show()
                                tvAUser.text.clear()
                                tvAPassword.text.clear()
                            }
                        }
                    } else {
                        Toast.makeText(this, "Usuario o Contraseña erronea", Toast.LENGTH_SHORT).show()
                        tvAUser.text.clear()
                        tvAPassword.text.clear()
                    }
                }
            } else {
                Toast.makeText(this, "No ingreso ningun dato", Toast.LENGTH_SHORT).show()
            }
        }
        tvARegresar.setOnClickListener {
            val intento = Intent(this,ElecLogeo::class.java)
            startActivity(intento)
        }
    }
}