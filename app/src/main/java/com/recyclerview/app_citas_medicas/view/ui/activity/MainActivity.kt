package com.recyclerview.app_citas_medicas.view.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentResultListener
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.recyclerview.app_citas_medicas.R
import com.recyclerview.app_citas_medicas.view.ui.fragments.IndiceFragment
import com.recyclerview.app_citas_medicas.view.ui.fragments.LoginAdministradorFragment
import kotlinx.android.synthetic.main.fragment_indice.*

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_indice)
        val fragmentInicio = IndiceFragment()
        val fragmentAdmin = LoginAdministradorFragment()
        supportFragmentManager.beginTransaction().replace(R.id.tvAdmin,fragmentInicio).commit()

    }
}