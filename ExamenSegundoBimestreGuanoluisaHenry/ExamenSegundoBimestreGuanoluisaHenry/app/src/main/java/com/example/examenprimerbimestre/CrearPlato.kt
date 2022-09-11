package com.example.examenprimerbimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CrearPlato : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_plato)
        val nombrePlato = findViewById<EditText>(R.id.txtnewNombrePlato)
        val precioPlato = findViewById<EditText>(R.id.txtNewPrecio)
        val regionPlato = findViewById<EditText>(R.id.txtNewRegion)
        val provinciaPlato = findViewById<EditText>(R.id.txtNewProvincia)
        val descripcionPlato = findViewById<EditText>(R.id.txtNewDescripcion)
        val boton = findViewById<Button>(R.id.btnCrearIngrdtes)
        boton
            .setOnClickListener {


                if(nombrePlato.text.isEmpty() || precioPlato.text.isEmpty() ||
                        regionPlato.text.isEmpty() || provinciaPlato.text.isEmpty() || descripcionPlato.text.isEmpty()){
                    val toast = Toast.makeText(this, "Campos son obligatorios", Toast.LENGTH_SHORT)
                    toast.show()
                }else{
                    devolverRespuesta(nombrePlato.text.toString(),
                        precioPlato.text.toString().toDouble(), regionPlato.text.toString(), provinciaPlato.text.toString(), descripcionPlato.text.toString())

                }


            }
    }
    fun devolverRespuesta(nombre:String, precio:Double, region:String, provincia:String, descripcion:String){

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