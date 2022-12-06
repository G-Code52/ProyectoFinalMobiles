package com.example.nutriiapp

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*


// Clase para implementar el Day Picker
// Recibe un listener de loso valores que queremos devolver (dia, mes, año)
// Extiende a Dialog Fragment, clase interna de android que permite mostrar los
// cuadros de dialogo
class DatePickerFragment(val listener: (date: Int, month:Int, year:Int) -> Unit): DialogFragment(),
    DatePickerDialog.OnDateSetListener{

    // Esta funcion nos va a avisar cuando se escoga una fecha en el calendario
    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        listener(day, month, year)
    }


    // Esta funcion inicia el calendario, coon la fecha del día
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance()         // Variable de tipo calendario
        val day = c.get(Calendar.DAY_OF_MONTH)      // Obtener el dia del calendario
        val month = c.get(Calendar.MONTH)           // Obtener el mes del calendario
        val year = c.get(Calendar.YEAR)             // Obtener el año del calendario

        // Crear la instancia del calendario que verá el usuario
        val picker = DatePickerDialog(activity as Context, this, year, month, day) // Convertimoos la activity a un contexto
        return picker
    }
}