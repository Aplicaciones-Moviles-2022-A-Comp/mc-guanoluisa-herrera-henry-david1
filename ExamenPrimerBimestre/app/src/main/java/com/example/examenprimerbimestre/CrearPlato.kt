package com.example.examenprimerbimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.Button
import android.widget.EditText

class CrearPlato : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_especie)
        val nombrePlato = findViewById<EditText>(R.id.txtnewNombrePlato)
        val precioPlato = findViewById<EditText>(R.id.txtNewPrecio)
        val regionPlato = findViewById<EditText>(R.id.txtNewRegion)
        val provinciaPlato = findViewById<EditText>(R.id.txtNewProvincia)
        val descripcionPlato = findViewById<EditText>(R.id.txtNewDescripcion)
        val boton = findViewById<Button>(R.id.btnCrearNewPlato)
        boton
            .setOnClickListener {
                devolverRespuesta(nombrePlato.text.toString(),
                    precioPlato.text.toString().toDouble(), regionPlato.text.toString(), provinciaPlato.text.toString(), descripcionPlato.text.toString())

            }




    }
    fun devolverRespuesta(nombre:String, precio:Double, region:String, provincia:String, descripcion:String){
        Log.d("CREAR PLATO", precio.toString());
        Log.d("CREAR PLATO", nombre);
        Log.d("CREAR PLATO", region);
        Log.d("CREAR PLATO", provincia);
        Log.d("CREAR PLATO", descripcion);
        val intentDevolverParametros = Intent()
        intentDevolverParametros.putExtra("nuevoNombrePlato", nombre )
        intentDevolverParametros.putExtra("nuevoPrecioPlato", precio )
        intentDevolverParametros.putExtra("nuevoRegionPlato", region )
        intentDevolverParametros.putExtra("nuevoProvinciaPlato", provincia )
        intentDevolverParametros.putExtra("nuevaDescripcionPlato", descripcion )
        setResult(
            RESULT_OK,
            intentDevolverParametros
        )
        finish()
    }


}