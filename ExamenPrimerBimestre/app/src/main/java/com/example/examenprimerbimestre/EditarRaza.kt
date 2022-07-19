package com.example.examenprimerbimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*

class EditarRaza : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_raza)
        val titulo = findViewById<TextView>(R.id.textTituloEditarRaza)
        val bundle = intent.extras
        var indice = bundle?.getString("nombreRaza")
        if (indice == null)
            indice = ""
        titulo.setText("$indice")
        val nombreRaza = findViewById<EditText>(R.id.txtUpdateNombreRaza)
        val domesticadoRaza = findViewById<RadioButton>(R.id.rdb_UpdateDomesticadoTrue)
        val nombreCientifico = findViewById<EditText>(R.id.txtUpdateNombreCientifico)
        val regionRaza = findViewById<EditText>(R.id.txtUpdateRegionRaza)
        val esperanzaVida = findViewById<EditText>(R.id.txtUpdateEsperanzaVida)
        val boton = findViewById<Button>(R.id.btnUpdateRaza)
        var domesticado = false
        if(domesticadoRaza.isChecked){
            domesticado = true
        }
        boton.setOnClickListener {
            editarRaza(indice, nombreRaza, nombreCientifico, domesticado, regionRaza, esperanzaVida)
        }
    }
    fun editarRaza(
        nombre: String,
        nombreRaza: EditText,
        nombreCientifico: EditText,
        domesticadoRaza: Boolean,
        regionRaza: EditText,
        esperanzaVida: EditText
    ) {
        var aux = ""
        BBaseDatosMemoria.arregloBRaza.filter { it.nombreRaza == nombre }
            .map {
                it.nombreRaza = nombreRaza.text.toString()
                it.nombreCientífico =nombreCientifico.text.toString()
                it.domesticado = domesticadoRaza
                it.maximaEsperanzaVida = esperanzaVida.text.toString().toInt()
                it.alimentacion = regionRaza.text.toString()
                it.nombreEspecie = it.nombreEspecie
                aux = it.nombreEspecie.toString()
            }
        Log.i("aux", "$aux")
        abrirActividad(Raza::class.java,aux )
    }
    private fun abrirActividad(
        clase: Class<*>,
        indice: String,
        ) {
        val i = Intent(this, clase)
        i.putExtra("idEspecie",indice )
        startActivity(i);
    }
}