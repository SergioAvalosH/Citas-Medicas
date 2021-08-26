package com.recyclerview.app_citas_medicas.view.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.activity_admin_menu.*

class AdminMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_menu)
        btn_manage_profiles.setOnClickListener {
            val intent = Intent(this, EditProfileManager::class.java)
            startActivity(intent)
        }
        btn_ME.setOnClickListener {
            val intent = Intent(this, MedicoEspecialidadMenu::class.java)
            startActivity(intent)
        }
    }
}