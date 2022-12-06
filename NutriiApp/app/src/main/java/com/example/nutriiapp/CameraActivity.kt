package com.example.nutriiapp

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.jar.Manifest

@Suppress("DEPRECATION")
class CameraActivity : AppCompatActivity(){

    private val REQUEST_GALLERY = 1001
    private val REQUEST_CAMERA = 1002
    private var btnGaleria: Button? = null
    private var btnAbrirCamara: Button? = null
    private var imgFoto: ImageView? = null

    var foto: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        btnGaleria = findViewById(R.id.btnGaleria)
        btnAbrirCamara = findViewById(R.id.btnAbrirCamara)

        abreGaleria_Click()
        abreCamara_Click()
    }

    // Detectamos cuando se pulse el boton para abrir la galeria
    private fun abreCamara_Click(){
        btnAbrirCamara?.setOnClickListener(){
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if (checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
                    || checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                    // Pedirle permiso al usuario
                    val permisosCamara = arrayOf(android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    requestPermissions(permisosCamara, REQUEST_CAMERA)
                }
                else{
                    abreCamara()
                }
            }
            else {
                abreCamara()
            }
        }

    }

    // Detectamos cuando se pulse el boton para abrir la galeria
    private fun abreGaleria_Click() {
        btnGaleria?.setOnClickListener(){
            // Verificamos que version de android esta instalada en el telefonoo
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                // Preguntamos si tiene permiso
                if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                    // Pedir permiso al usuario
                    val permisoArchivos = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permisoArchivos, REQUEST_GALLERY)
                }
                else{
                    // entonces si tiene permiso
                    muestraGaleria()
                }
            }
            else {
                // Tiene version de Lollipoop hacia abajo y por default tiene permiso
                muestraGaleria()
            }
        }

    }

    // Checamos si el usuari dio permiso a la app
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            REQUEST_GALLERY -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    muestraGaleria()
                else
                    Toast.makeText(this, "No hay permiso para acceder a tus imágenes",Toast.LENGTH_SHORT).show()
            }
            REQUEST_CAMERA -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    abreCamara()
                else
                    Toast.makeText(this, "No hay permiso para acceder a la camara",Toast.LENGTH_SHORT).show()

            }
        }

    }

    // Abre la ventana donde se muestra la galeria de fotos
    private fun muestraGaleria(){
        val intentGaleria = Intent(Intent.ACTION_PICK)
        intentGaleria.type = "image/*"
        startActivityForResult(intentGaleria, REQUEST_GALLERY)
    }

    private fun abreCamara(){
        val value = ContentValues()         // Manejador de Contenidoos, crea un espacio de memoria vacia
        value.put(MediaStore.Images.Media.TITLE, "Nueva imagen")
        foto = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, value)
        val camaraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        camaraIntent.putExtra(MediaStore.EXTRA_OUTPUT, foto)
        startActivityForResult(camaraIntent, REQUEST_CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_GALLERY){
            imgFoto?.setImageURI(data?.data)
        }
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CAMERA){
            imgFoto?.setImageURI(foto)
        }
    }
}