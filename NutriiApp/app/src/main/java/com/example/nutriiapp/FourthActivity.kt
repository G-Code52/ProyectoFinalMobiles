package com.example.nutriiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class FourthActivity : AppCompatActivity(), View.OnClickListener {

    private var cbGym: CheckBox? = null
    private var cbCrossfit: CheckBox? = null
    private var cbBaloncesto: CheckBox? = null
    private var cbFutbol: CheckBox? = null
    private var cbNatacion: CheckBox? = null
    private var cbVolleyball: CheckBox? = null

    private var btnContinuar4: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        cbGym = findViewById(R.id.cbGym)
        cbCrossfit = findViewById(R.id.cbCrossfit)
        cbBaloncesto = findViewById(R.id.cbBaloncesto)
        cbFutbol = findViewById(R.id.cbFutbol)
        cbNatacion = findViewById(R.id.cbNatacion)
        cbVolleyball = findViewById(R.id.cbVolleyball)

        btnContinuar4 = findViewById(R.id.btnContinuar4)
        btnContinuar4!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnContinuar4){
            Toast.makeText(this, "Datos Guardados", Toast.LENGTH_SHORT).show()

            val packageName = "com.example.nutriiapp"
            val className = "com.example.nutriiapp.MainMenuActivity"

            intent.setClassName(packageName, className)
            startActivity(intent)
        }
    }
}