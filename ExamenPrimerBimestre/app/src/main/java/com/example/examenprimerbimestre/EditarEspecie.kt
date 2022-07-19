package com.example.examenprimerbimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class EditarEspecie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_especie)
        val titulo = findViewById<TextView>(R.id.textNombreEspecie)
        val nombrePlato = findViewById<EditText>(R.id.txtnewNombreRaza)
        val precioPlato = findViewById<EditText>(R.id.txtEditPiel)
        val regionPlato = findViewById<RadioButton>(R.id.rdb_Edittrue)
        val provinciaPlato = findViewById<EditText>(R.id.txtEditPeso)
        val descripcionPlato = findViewById<EditText>(R.id.txtEditNumero)
        val boton = findViewById<Button>(R.id.btnCrearNuevaRaza)
        var amamantan = false
        /*if(amamantanEspecie.isChecked){
            amamantan = true
        }*/
        val bundle = intent.extras
        var indice = bundle?.getString("idEspecieEditar")
        if (indice == null)
            indice = ""
        titulo.setText("$indice")
        boton.setOnClickListener {
            editarEspecie(indice, nombrePlato, precioPlato, regionPlato, provinciaPlato, descripcionPlato)
            abrirActividad(Plato::class.java)
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
        BBaseDatosMemoria.arregloBEspecie.filter { it.nombre == nombre }
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


