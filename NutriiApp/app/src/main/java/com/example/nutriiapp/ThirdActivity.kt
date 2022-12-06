package com.example.nutriiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class ThirdActivity : AppCompatActivity(), View.OnClickListener {

    private var cbLigera: CheckBox? = null
    private var cbModerada: CheckBox? = null
    private var cbIntensa: CheckBox? = null

    private var btnContinuar3: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        cbLigera = findViewById(R.id.cbLigera)
        cbModerada = findViewById(R.id.cbModerada)
        cbIntensa = findViewById(R.id.cbIntensa)

        btnContinuar3 = findViewById(R.id.btnContinuar3)
        btnContinuar3!!.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if(view.id == R.id.btnContinuar3) {
            Toast.makeText(this, "Datos Guardados", Toast.LENGTH_SHORT).show()

            val packageName = "com.example.nutriiapp"
            val className = "com.example.nutriiapp.FourthActivity"

            intent.setClassName(packageName, className)
            startActivity(intent)
        }
    }
}