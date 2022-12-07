package com.example.nutriiapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button

private var btnCamara:Button? = null
private var btnUbicacion: Button? = null
private var btnDietas: Button? = null
private var btnSalir: Button? = null

class MainMenuActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        btnCamara = findViewById(R.id.btnCamara)
        btnCamara!!.setOnClickListener(this)

        btnUbicacion = findViewById(R.id.btnUbicacion)
        btnUbicacion!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnCamara){
            val packageName = "com.example.nutriiapp"
            val className = "com.example.nutriiapp.CameraActivity"

            intent.setClassName(packageName, className)
            startActivity(intent)
        }
        if (view.id == R.id.btnUbicacion){
            val packageName = "com.example.nutriiapp"
            val className = "com.example.nutriiapp.UbicationActivity"

            intent.setClassName(packageName, className)
            startActivity(intent)
        }
    }
}