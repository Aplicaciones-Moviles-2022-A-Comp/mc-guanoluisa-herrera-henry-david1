package com.example.examenprimerbimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class EditarIngrediente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_raza)
        val titulo = findViewById<TextView>(R.id.txtTituloPlato)
        val bundle = intent.extras
        var indice = bundle?.getString("nombrePlato")
        if (indice == null)
            indice = ""
        titulo.setText("$indice")

        val ingrediente1 = findViewById<EditText>(R.id.txtUpdateIng1)
        val ingrediente2 = findViewById<EditText>(R.id.txtUpdateIng2)
        val ingrediente3 = findViewById<EditText>(R.id.txtUpdateIng3)
        val ingrediente4 = findViewById<EditText>(R.id.txtUpdateIng4)
        val ingrediente5 = findViewById<EditText>(R.id.txtUpdateIng5)
        val boton = findViewById<Button>(R.id.btnUpdateRaza)

        BBaseDatosMemoria.arregloBIngrediente.filter { it.nombrePlato == indice }
            .map {
                ingrediente1.setText(it.ingrediente1)
                ingrediente2.setText(it.ingrediente2)
                ingrediente3.setText(it.ingrediente3)
                ingrediente4.setText(it.ingrediente4)
                ingrediente5.setText(it.ingrediente5)
            }

        boton.setOnClickListener {
            editarIngrediente(indice, ingrediente1, ingrediente2, ingrediente3, ingrediente4, ingrediente5)
        }
    }
    fun editarIngrediente(
        nombre: String,
        ingrediente1: EditText,
        ingrediente2: EditText,
        ingrediente3: EditText,
        ingrediente4: EditText,
        ingrediente5: EditText
    ) {
        var aux = ""
        BBaseDatosMemoria.arregloBIngrediente.filter { it.nombrePlato == nombre }
            .map {
                it.ingrediente1 = ingrediente1.text.toString()
                it.ingrediente2 = ingrediente2.text.toString()
                it.ingrediente3 = ingrediente3.text.toString()
                it.ingrediente4 = ingrediente4.text.toString()
                it.ingrediente5 = ingrediente5.text.toString()
                it.nombrePlato = it.nombrePlato
                aux = it.nombrePlato.toString()
            }
        abrirActividad(Ingrediente::class.java,aux )
    }
    private fun abrirActividad(
        clase: Class<*>,
        indice: String,
        ) {
        val i = Intent(this, clase)
        i.putExtra("idPlato",indice )
        startActivity(i);
    }
}