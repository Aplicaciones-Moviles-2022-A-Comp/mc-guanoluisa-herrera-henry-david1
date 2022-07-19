package com.example.examenprimerbimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class CrearEspecie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_especie)
        val nombreEspecie = findViewById<EditText>(R.id.txtnewNombreEspecie)
        val pielEspecie = findViewById<EditText>(R.id.txtNewPiel)
        val btnSi = findViewById<RadioButton>(R.id.siDomesticadoCrear);
        val btnNo = findViewById<RadioButton>(R.id.noDomesticadoCrear);
        val pesoMaxEspecie = findViewById<EditText>(R.id.txtNewPeso)
        val numeroEspecie = findViewById<EditText>(R.id.txtNewNumero)
        val boton = findViewById<Button>(R.id.btnCrearNuevaRaza)
        boton
            .setOnClickListener {
                if (btnSi.isChecked)
                    devolverRespuesta(nombreEspecie.getText().toString(),
                        pielEspecie.getText().toString(), true, pesoMaxEspecie.getText().toString(), numeroEspecie.getText().toString())
                if (btnNo.isChecked)
                    devolverRespuesta(nombreEspecie.getText().toString(),
                        pielEspecie.getText().toString(), false, pesoMaxEspecie.getText().toString(), numeroEspecie.getText().toString())
            }
    }
    fun devolverRespuesta(nombre:String, piel:String,amamantan:Boolean, peso:String, numero:String){
        val intentDevolverParametros = Intent()
        intentDevolverParametros.putExtra("nuevaNombreEspecie",nombre )
        intentDevolverParametros.putExtra("nuevaPielEspecie",piel )
        intentDevolverParametros.putExtra("nuevaAmamantanEspecie",amamantan )
        intentDevolverParametros.putExtra("nuevaPesoEspecie",peso )
        intentDevolverParametros.putExtra("nuevaNumeroEspecie",numero )
        setResult(
            RESULT_OK,
            intentDevolverParametros
        )
        finish()
    }


}