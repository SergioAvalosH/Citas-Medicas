package com.recyclerview.app_citas_medicas.view.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.maps.GoogleMap
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import com.recyclerview.app_citas_medicas.view.ui.fragments.pacienteFragments.EditPacienteProfileFragment
import com.recyclerview.app_citas_medicas.view.ui.fragments.pacienteFragments.ProfileFragment
import com.recyclerview.app_citas_medicas.view.ui.interfaces.Comunicador_Act_Frag
import com.recyclerview.app_citas_medicas.view.ui.interfaces.Comunicator_Paciente
import kotlinx.android.synthetic.main.fragment_edit_paciente_profile.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class PacienteActivity : AppCompatActivity(), Comunicator_Paciente, Comunicador_Act_Frag {

    private lateinit var map:GoogleMap
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paciente)

        // Para la navegacion
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment) // el fragmento de la actividad paciente
        // PAra el bar de navegacion
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.citasFragment, R.id.profileFragment))
        setupActionBarWithNavController(navController,appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController) // IControlador de l navegation

        // Para ir al mapa
        verUbicacionHospital.setOnClickListener{
            val intent = Intent(this, UbicacionActivity::class.java)
            startActivity(intent)
        }

        // Para crear una nueva cita
        crearCitaPaciente.setOnClickListener{
            val intent = Intent(this, CrearCitaActivity::class.java)
            startActivity(intent)
        }

        val dni: String? = intent.getStringExtra("dni")


        mensajeBienvenidaDNI.text= dni

    }


    // Para ser el puente entre fragments para pasar los datos del fragment_profile y fragment_edit_paciente_prodfile
    override fun passDataFroProfiletoEdite(dnitext: String) {
        val bundle = Bundle()
        bundle.putString("dni", dnitext)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentEditPacienteProfile = EditPacienteProfileFragment()
        fragmentEditPacienteProfile.arguments= bundle
        // Intercambio de fragments
        transaction.replace(R.id.fragmentPerfilPaciente, fragmentEditPacienteProfile)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun comunicadorActivityMai_ProfileFragment(dniPac: String) {
        val bundle = Bundle()
        bundle.putString("dni", dniPac)

        val fragmentPacienteProfile = ProfileFragment()
        fragmentPacienteProfile.arguments= bundle
        // Intercambio de fragments
    }
}