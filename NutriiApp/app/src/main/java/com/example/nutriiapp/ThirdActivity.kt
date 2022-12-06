package com.example.nutriiapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class ThirdActivity : AppCompatActivity(), View.OnClickListener {

    private var cbLigera: RadioButton? = null
    private var cbModerada: RadioButton? = null
    private var cbIntensa: RadioButton? = null

    private var btnContinuar3: Button? = null

    var amount = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        cbLigera = findViewById(R.id.cbLigera)
        cbModerada = findViewById(R.id.rHombre)
        cbIntensa = findViewById(R.id.rMujer)

        btnContinuar3 = findViewById(R.id.btnContinuar3)
        btnContinuar3!!.setOnClickListener(this)

    }


    override fun onClick(view: View) {
        if(view.id == R.id.btnContinuar3) {

            if (cbLigera?.isChecked() == true) {
                amount = "Ligera";
            }
            if (cbModerada?.isChecked() == true) {
                amount = "Moderada";
            }
            if (cbIntensa?.isChecked() == true) {
                amount = "Intensa";
            }

            var fireStore = FirebaseFirestore.getInstance()
            val activity: MutableMap<String, Any> = HashMap()
            activity["amount"] = amount
            fireStore.collection("activity").add(activity)


            Toast.makeText(this, "Datos Guardados", Toast.LENGTH_SHORT).show()

            val packageName = "com.example.nutriiapp"
            val className = "com.example.nutriiapp.FourthActivity"

            intent.setClassName(packageName, className)
            startActivity(intent)
        }


    }


}