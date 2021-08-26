package com.recyclerview.app_citas_medicas.view.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.activity_medico_especialidad_menu.*

class MedicoEspecialidadMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medico_especialidad_menu)
        btn_return_me.setOnClickListener {
            val intent = Intent(this, AdminMenu::class.java)
            startActivity(intent)
        }
    }
}