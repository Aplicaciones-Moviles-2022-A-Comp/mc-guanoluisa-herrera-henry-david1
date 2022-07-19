package com.example.examenprimerbimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class CrearRaza : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_raza)
        val nombreRaza = findViewById<EditText>(R.id.txtnewNombreRaza)
        val domesticadoRaza = findViewById<RadioButton>(R.id.rdb_DomesticadoTrue)
        val nombreCientifico = findViewById<TextView>(R.id.txtNewNombreCientifico)
        val regionRaza = findViewById<EditText>(R.id.txtNewRegionRaza)
        val esperanzaVida = findViewById<EditText>(R.id.txtNewEsperanzaVida)
        val boton = findViewById<Button>(R.id.btnCrearNuevaRaza)
        val bundle = intent.extras
        var especie = bundle?.getString("idEspecieCrear")
        if (especie == null)
            especie = ""
        var domesticado = false
        if(domesticadoRaza.isChecked){
            domesticado = true
        }
        boton
            .setOnClickListener {
                val i = Intent(this,Raza::class.java)
                i.putExtra("idEspecie",especie )
                crearRaza(nombreRaza.getText().toString(),nombreCientifico.getText().toString(),
                regionRaza.getText().toString(), esperanzaVida.getText().toString().toInt(),domesticado , especie)
                startActivity(i)
            }
    }
    fun crearRaza(nombre:String, nombreCientifico:String,  region:String, esperanza:Int, domesticado:Boolean, nombreEspecie:String){
        BBaseDatosMemoria.arregloBRaza.add(BRaza(nombre, nombreCientifico, region, esperanza, domesticado, nombreEspecie ))

    }

}