package com.example.myapplicationh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main

            val = botonCicloVida = findViewById<Button>(R.id.btn_ciclo_vida)
        botonCicloVida
            .setOnClickListener{
                irActividad(ACicloVida::class.java)

            }
    }
 fun irActividad (

     clase: Class <*>
 ){

     vale intent = Intent(this, clase)
     startActivity (intent)
 }


}