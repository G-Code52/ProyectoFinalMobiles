package com.example.nutriiapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity(), View.OnClickListener {


    private var swDiabetes: Switch? = null
    private var swHipertension: Switch? = null
    private var swTiroides: Switch? = null
    private var swObesidad: Switch? = null
    private var swCancer: Switch? = null
    private var edtAntecedentes: EditText? = null
    private var btnContinuar2: Button? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        swDiabetes = findViewById(R.id.swDiabetes)
        swHipertension = findViewById(R.id.swHipertension)
        swTiroides = findViewById(R.id.swTiroides)
        swObesidad = findViewById(R.id.swObseidad)
        swCancer = findViewById(R.id.swCancer)
        edtAntecedentes = findViewById(R.id.edtAntecedentes)

        btnContinuar2 = findViewById(R.id.btnContinuar2)
        btnContinuar2!!.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnContinuar2) {
            edtAntecedentes?.setText("")
            Toast.makeText(this, "Datos Guardados", Toast.LENGTH_SHORT).show()

            val packageName = "com.example.nutriiapp"
            val className = "com.example.nutriiapp.ThirdActivity"
            intent.setClassName(packageName, className)
            startActivity(intent)
        }
    }
}