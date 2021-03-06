package com.example.examenprimerbimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CrearIngrediente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_ingrediente)
        val ingrediente1 = findViewById<EditText>(R.id.txtIngrediente1)
        val ingrediente2 = findViewById<EditText>(R.id.txtIngrediente2)
        val ingrediente3 = findViewById<EditText>(R.id.txtIngrediente3)
        val ingrediente4 = findViewById<EditText>(R.id.txtIngrediente4)
        val ingrediente5 = findViewById<EditText>(R.id.txtIngrediente5)
        val boton = findViewById<Button>(R.id.btnCrearIngrdtes)
        val bundle = intent.extras
        var plato = bundle?.getString("idPlatoCrear")
        if(plato == null){
            plato = ""
        }
        boton
            .setOnClickListener {

                if(ingrediente1.text.isEmpty() || ingrediente2.text.isEmpty() || ingrediente3.text.isEmpty()
                    || ingrediente4.text.isEmpty() || ingrediente5.text.isEmpty()){
                    val toast = Toast.makeText(this, "Campos son obligatorios", Toast.LENGTH_SHORT)
                    toast.show()
                }else{
                    val i = Intent(this,Ingrediente::class.java)
                    i.putExtra("idPlato", plato )
                    crearIngrediente(ingrediente1.getText().toString(), ingrediente2.getText().toString(),
                        ingrediente3.getText().toString(), ingrediente4.getText().toString(), ingrediente5.getText().toString(), plato)
                    startActivity(i)
                }
            }
    }
    fun crearIngrediente(ingrediente1:String, ingrediente2:String,  ingrediente3:String, ingrediente4:String, ingrediente5:String, nombrePlato:String){
        BBaseDatosMemoria.arregloBIngrediente.add(BIngrediente(ingrediente1, ingrediente2, ingrediente3, ingrediente4, ingrediente5, nombrePlato ))

    }

}