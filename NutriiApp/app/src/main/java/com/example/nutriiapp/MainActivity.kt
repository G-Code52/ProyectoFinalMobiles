package com.example.nutriiapp

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Zona de inicializadores
    private var txtBienvenida:TextView? = null         // Mensaje de Bienvenida
    private var edtNombre:EditText? = null              // Campo para el Nombre
    private var edtNumCel:EditText? = null              // Campo para el Numero de telefono
    private lateinit var edtFechaNacimiento:EditText     // Campo para la fecha
    private var edtHombreMujer:EditText? = null         // Campo para el Sexo
    private var btnContinuar:Button? = null             // Boton Continuar
    private var rHombre:RadioButton? = null
    private var rMujer:RadioButton? = null
    private var nom: String? = null
    private var num: String? = null
    private var fecha: String? = null
    private var sexo: String? = null
    private var misDatos: SharedPreferences? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtBienvenida = findViewById(R.id.txtBienvenida)
        edtNombre = findViewById(R.id.edtNombre)
        edtFechaNacimiento = findViewById(R.id.edtFechaNacimiento)
        edtNumCel = findViewById(R.id.edtNumCel)
        rHombre = findViewById(R.id.cbModerada)
        rMujer = findViewById(R.id.cbIntensa)
        btnContinuar = findViewById(R.id.btnContinuar)

        btnContinuar!!.setOnClickListener(this)

        // Funcion para abrir cuadroo de dialogo para escoger el día de nacimiento
        edtFechaNacimiento.setOnClickListener { showDatePickerDialog() }


    }




    override fun onClick(view: View) {
        if (view.id == R.id.btnContinuar) {

            var fireStore = FirebaseFirestore.getInstance()
            val user: MutableMap<String, Any> = HashMap()
            user["name"] = edtNombre?.text.toString()
            user["birth"] = edtFechaNacimiento?.text.toString()
            user["phone"] = edtNumCel?.text.toString()

            if(rHombre?.isChecked() == true){
                user["gender"] = "Hombre"
            }
            else if(rMujer?.isChecked() == true){
                user["gender"] = "Mujer"
            }

            fireStore.collection("users").add(user)

            edtNombre?.setText("")
            edtNumCel?.setText("")
            edtFechaNacimiento.setText("")
            edtHombreMujer?.setText("")
            Toast.makeText(this, "Datos Guardados", Toast.LENGTH_SHORT).show()

            val packageName = "com.example.nutriiapp"
            val className = "com.example.nutriiapp.SecondActivity"
            intent.setClassName(packageName,className)
            startActivity(intent)
        }


    }

    /*
    override fun onPause() {
        super.onPause()

        // Recolectar los Strings de los Edit Text
        nom = edtNombre?.text.toString()
        num = edtNumCel?.text.toString()
        fecha = edtFechaNacimiento?.text.toString()
        sexo = edtHombreMujer?.text.toString()

        // Escribir los datos
        val editor = misDatos!!.edit()
        editor.putString("Nombre", nom)
        editor.putString("Numero", num)
        editor.putString("Fecha de Nacimiento", fecha)
        editor.putString("Hombre/Mujer", sexo)

        // Aplicar los cambios
        editor.apply()
        Toast.makeText(this, "Preferencias Guardadas", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        val misDatos = getSharedPreferences("preferencias", MODE_PRIVATE)
        nom = misDatos.getString("Nombre", "Valor por default")
        num = misDatos.getString("Numero", "Valor por default")
        fecha = misDatos.getString("Fecha de Nacimiento", "Valor por default")
        sexo = misDatos.getString("Hombre/Mujer", "Valor por default")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val editor = misDatos!!.edit()
        editor.putString("Clave", "Valor")
        editor.commit()
        super.onSaveInstanceState(outState)
    }*/

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment {day, month, year -> onDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day:Int, month:Int, year:Int){
        edtFechaNacimiento.setText("$day/$month/$year")
    }
}