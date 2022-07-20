package com.example.examenprimerbimestre

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*

class Ingrediente : AppCompatActivity() {
    var idItemSeleccionado = 0
    var nombrePlato = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raza)
        val titulo = findViewById<TextView>(R.id.textView_ingrediente)
        val listView = findViewById<ListView>(R.id.lv_list_view)
        val botonRegresar = findViewById<Button>(R.id.btnRegresarIng)
        botonRegresar.setOnClickListener {
            val i = Intent(this, Plato::class.java)
            startActivity(i)
        }
        val bundle = intent.extras
        nombrePlato = bundle?.getString("idPlato").toString()
        if (nombrePlato == null)
            nombrePlato = ""
        titulo.setText("$nombrePlato")
        val nuevoArreglo = BBaseDatosMemoria.arregloBIngrediente.filter { it.nombrePlato == nombrePlato }
        val adaptador = ArrayAdapter(
            this, // Contexto
            android.R.layout.simple_list_item_1, // como se va a ver (XML)
            nuevoArreglo
        )
        listView.adapter = adaptador
        val botonAnadirListView = findViewById<Button>(R.id.btnCrearIngrediente)
        botonAnadirListView
            .setOnClickListener {
                val i = Intent(this, CrearIngrediente::class.java)
                i.putExtra("idPlatoCrear", "$nombrePlato")
                startActivity(i)
            }

        registerForContextMenu(listView)
        adaptador.notifyDataSetChanged()
    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.raza, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        idItemSeleccionado = id
    }
    override fun onContextItemSelected(
        item: MenuItem,
    ): Boolean {
        return when (item.itemId) {
            R.id.mi_editar -> {
                val i = Intent(this, EditarIngrediente::class.java)
                val nuevoArreglo = BBaseDatosMemoria.arregloBIngrediente.filter { it.nombrePlato == nombrePlato }
                i.putExtra("nombrePlato", "${nuevoArreglo[idItemSeleccionado].nombrePlato}");
                startActivity(i);
                return true
            }
            R.id.mi_eliminar -> {
                elimarRaza()
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }
    fun elimarRaza() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Desea eliminar")
            .setPositiveButton("Aceptar",
                DialogInterface.OnClickListener { dialog, id ->
                    BBaseDatosMemoria.arregloBIngrediente.removeAt(idItemSeleccionado)
                    Log.i("context-menu", "Editar Posicion: ${idItemSeleccionado}")
                    val listView = findViewById<ListView>(R.id.lv_list_view)
                    val adaptador = ArrayAdapter(
                        this, // Contexto
                        android.R.layout.simple_list_item_1, // como se va a ver (XML)
                        BBaseDatosMemoria.arregloBIngrediente
                    )
                    listView.adapter = adaptador
                })
            .setNegativeButton("Cancelar",
                DialogInterface.OnClickListener { dialog, id ->
                    // User cancelled the dialog
                })
        // Create the AlertDialog object and return it
        val dialogo = builder.create()
        dialogo.show()    }
}