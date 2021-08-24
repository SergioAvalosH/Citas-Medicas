package com.recyclerview.app_citas_medicas.view.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.recyclerview.app_citas_medicas.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val animacion1= AnimationUtils.loadAnimation(this,R.anim.anim_splash)
        val animacion2 = AnimationUtils.loadAnimation(this,R.anim.anim_middle)


        val splashScreenTimeOutput =  2000


        val home = Intent(this@SplashScreen,MainActivity::class.java)

        Handler().postDelayed({
            startActivity(home)
            finish()
        },splashScreenTimeOutput.toLong())


    }
}