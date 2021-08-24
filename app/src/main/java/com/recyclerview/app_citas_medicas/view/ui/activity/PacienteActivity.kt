package com.recyclerview.app_citas_medicas.view.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.recyclerview.app_citas_medicas.R
import com.recyclerview.app_citas_medicas.view.ui.fragments.pacienteFragments.EditPacienteProfileFragment
import com.recyclerview.app_citas_medicas.view.ui.interfaces.Comunicator_Paciente

class PacienteActivity : AppCompatActivity(), OnMapReadyCallback, Comunicator_Paciente {

    private lateinit var map:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paciente)

        // Para la navegacion
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment) // el fragmento de la actividad paciente
        // PAra el bar
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.citasFragment, R.id.ubicacionFragment, R.id.profileFragment))
        setupActionBarWithNavController(navController,appBarConfiguration)
        bottomNavigationView.setupWithNavController(navController) // IControlador de l navegation

        // Para google Map - Agregarlo de forma dinamica
        val mapFragment = SupportMapFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.qwerty, mapFragment)
            .commit()

    }
    // Para greear el google map
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }
    private fun createMarker(){
        val coordinates = LatLng(-9.075513, -78.602313)
        val marker = MarkerOptions().position(coordinates).title("Hospital la Caleta")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates,18f),
            4000,
            null

        )
    }

    // Para ser el puente entre fragments para pasar los datos del fragment_profile y fragment_edit_paciente_prodfile
    override fun passDataFroProfiletoEdite(dnitext: String) {
        val bundle = Bundle()
        bundle.putString("dni", dnitext)

        val transaction = this.supportFragmentManager.beginTransaction()
        val fragmentEditPacienteProfile = EditPacienteProfileFragment()
        fragmentEditPacienteProfile.arguments= bundle

        transaction.replace(R.id.profileFragment, fragmentEditPacienteProfile)
        transaction.commit()

    }
}