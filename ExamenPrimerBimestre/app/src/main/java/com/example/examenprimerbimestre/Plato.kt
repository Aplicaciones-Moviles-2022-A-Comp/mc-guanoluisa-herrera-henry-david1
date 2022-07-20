package com.example.examenprimerbimestre

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts

class Plato : AppCompatActivity() {
    var idItemSeleccionado = 0
    var resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            if(result.data != null){
                val listView = findViewById<ListView>(R.id.lv_list_view)
                val data = result.data
                val nuevoNombrePlato = data?.getStringExtra("nuevoNombrePlato").toString()
                val nuevoPrecio = data?.getStringExtra("nuevoPrecioPlato").toString().toDouble()
                val nuevaRegion = data?.getStringExtra("nuevoRegionPlato").toString()
                val nuevaProvincia = data?.getStringExtra("nuevoProvinciaPlato").toString()
                val nuevaDecripcion = data?.getStringExtra("nuevaDescripcionPlato").toString()
                BBaseDatosMemoria.arregloBEspecie.add(BPlato(nuevoNombrePlato, nuevoPrecio, nuevaRegion, nuevaProvincia, nuevaDecripcion))
                val adaptador = ArrayAdapter(
                    this, // Contexto
                    android.R.layout.simple_list_item_1, // como se va a ver (XML)
                    BBaseDatosMemoria.arregloBEspecie
                )
                listView.adapter = adaptador
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_especie)
        val listView = findViewById<ListView>(R.id.lv_list_view)
        val adaptador = ArrayAdapter(
            this, // Contexto
            android.R.layout.simple_list_item_1, // como se va a ver (XML)
            BBaseDatosMemoria.arregloBEspecie
        )
        listView.adapter = adaptador
        val botonAnadirListView = findViewById<Button>(R.id.btnCrearRaza)
        botonAnadirListView
            .setOnClickListener {
                abrirActividadConParametros(CrearPlato::class.java)

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
        inflater.inflate(R.menu.menu, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        idItemSeleccionado = id
    }
    override fun onContextItemSelected(
        item: MenuItem,
    ): Boolean {
        return when (item.itemId) {
            R.id.mi_editar -> {
                val i = Intent(this, EditarPlato::class.java)
                i.putExtra("idEspecieEditar", "${BBaseDatosMemoria.arregloBEspecie[idItemSeleccionado].nombre}");
                startActivity(i);
                return true
            }
            R.id.mi_eliminar -> {
                elimarEspecie()
                return true
            }
            R.id.mi_ver_raza -> {
                val i = Intent(this, Ingrediente::class.java)
                i.putExtra("idEspecie", "${BBaseDatosMemoria.arregloBEspecie[idItemSeleccionado].nombre}");
                startActivity(i)
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    fun abrirActividadConParametros(
        clase: Class<*>
        ) {
        val intentExplicito = Intent(this, clase)
        resultLauncher.launch(intentExplicito)
    }
    fun elimarEspecie(){
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Desea eliminar")
            .setPositiveButton("Aceptar",
                DialogInterface.OnClickListener { dialog, id ->
                    BBaseDatosMemoria.arregloBEspecie.removeAt(idItemSeleccionado)
                    Log.i("context-menu", "Editar Posicion: ${idItemSeleccionado}")
                    val listView = findViewById<ListView>(R.id.lv_list_view)
                    val adaptador = ArrayAdapter(
                        this, // Contexto
                        android.R.layout.simple_list_item_1, // como se va a ver (XML)
                        BBaseDatosMemoria.arregloBEspecie
                    )
                    listView.adapter = adaptador
                })
            .setNegativeButton("Cancelar",
                DialogInterface.OnClickListener { dialog, id ->
                    // User cancelled the dialog
                })
        // Create the AlertDialog object and return it
        val dialogo = builder.create()
        dialogo.show()
    }
}