package com.example.nutriiapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class FifthActivity: AppCompatActivity(), View.OnClickListener {

    private var edtComidasDia: EditText? = null
    private var edtIntolerante: EditText? = null
    private var edtDisgusto: EditText? = null
    private var edtMonto: EditText? = null
    private var cbMenu1: EditText? = null
    private var cbMenu2: EditText? = null
    private var cbMenu3: EditText? = null

    private var txtHabitos:TextView? = null
    private var txtMontoPlan:TextView? = null


    private var btnContinuar5: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fifth)

        edtComidasDia = findViewById(R.id.edtComidasDia)
        edtIntolerante = findViewById(R.id.edtIntolerante)
        edtDisgusto = findViewById(R.id.edtDisgusto)
        edtMonto = findViewById(R.id.edtMonto)

        cbMenu1 = findViewById(R.id.cbMenu1)
        cbMenu2 = findViewById(R.id.cbMenu2)
        cbMenu3 = findViewById(R.id.cbMenu3)

        txtHabitos = findViewById(R.id.txtHabitos)
        txtMontoPlan = findViewById(R.id.txtMontoPlan)

        btnContinuar5 = findViewById(R.id.btnContinuar5)
        btnContinuar5!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnContinuar5) {

            Toast.makeText(this, "Datos Guardados", Toast.LENGTH_SHORT).show()

            val packageName = "com.example.nutriiapp"
            val className = "com.example.nutriiapp.MainMenuActivity"

            intent.setClassName(packageName, className)
            startActivity(intent)
        }
    }
}
