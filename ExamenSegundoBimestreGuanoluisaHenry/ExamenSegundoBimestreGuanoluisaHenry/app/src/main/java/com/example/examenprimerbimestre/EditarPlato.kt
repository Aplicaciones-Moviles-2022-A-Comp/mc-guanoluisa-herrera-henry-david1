package com.example.examenprimerbimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class EditarPlato : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_plato)
        val titulo = findViewById<TextView>(R.id.textNombrePlato)
        val nombrePlato = findViewById<EditText>(R.id.txtEditNombrePlato)
        val precioPlato = findViewById<EditText>(R.id.txtEditPrecioPlato)
        val regionPlato = findViewById<EditText>(R.id.txtEditRegion)
        val provinciaPlato = findViewById<EditText>(R.id.txtEditProvincia)
        val descripcionPlato = findViewById<EditText>(R.id.txtEditDescripcion)
        val boton = findViewById<Button>(R.id.btnCrearIngrdtes)
        val bundle = intent.extras
        var indice = bundle?.getString("idPlatoEditar")
        if (indice == null)
            indice = ""
        titulo.setText("$indice")
        BBaseDatosMemoria.arregloBPlato.filter { it.nombre == indice }
            .map {
                nombrePlato.setText(it.nombre)
                precioPlato.setText(it.precio.toString())
                regionPlato.setText(it.region)
                provinciaPlato.setText(it.provincia)
                descripcionPlato.setText(it.descripcion)
            }
        boton.setOnClickListener {

            if(nombrePlato.text.isEmpty() || precioPlato.text.isEmpty() ||
                regionPlato.text.isEmpty() || provinciaPlato.text.isEmpty() || descripcionPlato.text.isEmpty()){
                val toast = Toast.makeText(this, "Campos son obligatorios", Toast.LENGTH_SHORT)
                toast.show()
            }else{
                editarEspecie(indice, nombrePlato, precioPlato, regionPlato, provinciaPlato, descripcionPlato)
                abrirActividad(Plato::class.java)
            }


        }

        }
    fun editarEspecie(
        nombre: String,
        nombrePlato: EditText,
        precioPlato: EditText,
        regionPlato: EditText,
        provinciaPlato: EditText,
        descripcionPlato: EditText
    ) {
        BBaseDatosMemoria.arregloBPlato.filter { it.nombre == nombre }
            .map {
                it.nombre = nombrePlato.text.toString()
                it.precio = precioPlato.text.toString().toDouble()
                it.region = regionPlato.text.toString()
                it.provincia = provinciaPlato.text.toString()
                it.descripcion = descripcionPlato.text.toString()
            }
    }

    private fun abrirActividad(
        clase: Class<*>,

    ) {
        val i = Intent(this, clase)
        startActivity(i);
    }

}


