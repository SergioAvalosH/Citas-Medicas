package com.recyclerview.app_citas_medicas.view.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.activity_elec_logeo.*

class ElecLogeo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elec_logeo)
        btvPaciente.setOnClickListener {
            val intento = Intent(this,MainActivity::class.java)
            startActivity(intento)
        }
        btvAdmin.setOnClickListener {
            val intento = Intent(this,MainActivity::class.java)
            startActivity(intento)
        }
    }
}