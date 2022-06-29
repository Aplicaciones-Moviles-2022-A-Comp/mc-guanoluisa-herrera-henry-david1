import java.io.*
import java.util.*
import kotlin.collections.ArrayList


fun main(){
    var plato: Plato
    var ingrediente: Ingrediente
    Plato.actualizarPlato()
    Ingrediente.actualizarIngrediente()
    var select = 2
    do {
        println("Elige opción:\n" +
                "0. Salir\n" +
                "1. Crear Plato Tipico\n" +
                "2. Leer  Plato Tipico\n"+
                "3. Eliminar Plato Tipico\n" +
                "4. Actualizar Plato Tipico\n" +
                "5. Añadir Ingrediente\n" +
                "Ingrese la opción:")
        val selected = readLine()!!.toInt()
        when (selected){
            1 -> {
                
                plato = Plato(cargarString("Nombre del Plato Tipico"),cargarString("Origen"),cargarString("Region"), cargarString("Calificacion"), cargarDouble("Precio"))
                Plato.crearPlato(plato)
                Plato.actualizarPlato()
            }
            2->{
                Plato.leerPlato()
            }
            3 ->{
                Plato.leerPlato()
                println("Ingrese el indice del Plato Tipico para eliminar:")
                val valor = readLine()!!.toInt()
                Plato.eliminarPlato(valor)
                Plato.actualizarPlato()
            }
            4 ->{
                Plato.leerPlato()
                println("Ingrese el indice del Plato Tipico para actualizar:")
                val valor = readLine()!!.toInt()
                Plato.updatePlato(valor)
                Plato.actualizarPlato()
            }
            5->{
                var select1 = 1
                do{
                    println("Elige opción:\n" +
                            "0. Regresar al anterior\n" +
                            "1. Añadir Ingredientes\n" +
                            "2. Leer  Ingredientes\n"+
                            "3. Eliminar Ingredientes\n" +
                            "4. Actualizar Ingredientes\n" +
                            "Ingrese la opción:")
                    val selected1 = readLine()!!.toInt()
                    when(selected1){
                        1->{
                            Plato.leerPlato()
                            println("Ingrese el indice del Plato Tipico para añadir los Ingrediente:")
                            val indice = readLine()!!.toInt()

                            ingrediente = Ingrediente (cargarString("Ingrediente 1"), cargarString("Ingrediente 2"), cargarString("Ingrediente 3"), cargarString("Ingrediente 4"), cargarString("Ingrediente 5")
                            , Plato.listaPlato[indice].nombrePlato, Plato.listaPlato[indice].origenPlato, Plato.listaPlato[indice].regionPlato
                            , Plato.listaPlato[indice].calificacionPlato, Plato.listaPlato[indice].precioPlato)
                            Ingrediente.crearIngrediente(ingrediente)
                            Ingrediente.actualizarIngrediente()
                        }
                        2->{
                            Ingrediente.leerIngrediente()
                        }
                        3 ->{
                            Ingrediente.leerIngrediente()
                            println("Ingrese el indice del Ingrediente para eliminar:")
                            val valor = readLine()!!.toInt()
                            Ingrediente.eliminarIngrediente(valor)
                            Ingrediente.actualizarIngrediente()
                        }
                        4 ->{
                            Ingrediente.leerIngrediente()
                            println("Ingrese el indice del Ingrediente para actualizar:")
                            val valor = readLine()!!.toInt()
                            Ingrediente.updateIngrediente(valor)
                            Ingrediente.actualizarIngrediente()
                        }
                        0->{
                            println("¿Deseas regresar al otro nodo? S/N ")
                            println("Digita 1 =  Si Digita 2 = No ")
                            val seleccionado = readLine()!!.toInt()
                            if ( seleccionado == 1)
                                select1 = 0
                        }
                        else ->{
                            println("Número no reconocido")
                        }
                    }
                }while(select1 != 0)
            }
            0->{
                println("¿Deseas salir? S/N ")
                println("Digita 1 =  Si Digita 2 = No ")
                val seleccionado = readLine()!!.toInt()
                if ( seleccionado == 1)
                    select = 0
            }
            else ->{
                println("Número no reconocido")
            }

        }


    }while (select != 0)

}


fun cargarString(titulo: String):  String{
    print("Ingrese  ${titulo}:")
    val valor = readLine()!!.toString()
    return valor
}

fun cargarDouble(titulo: String):  Double{
    print("Ingrese  ${titulo}:")
    val valor = readLine()!!.toDouble()
    return valor
}

open class Plato(
    var nombrePlato: String,
    var origenPlato: String,
    var regionPlato: String,
    var calificacionPlato: String,
    var precioPlato: Double
) {

    companion object {
        val listaPlato: ArrayList<Plato> = arrayListOf()
        fun crearPlato(PlatoNueva:Plato){
            listaPlato.add(PlatoNueva)
            println("Plato agregada!!")
        }
        fun leerPlato(){
            listaPlato
                .forEachIndexed() { index: Int, valorActual: Plato ->
                    println("Plato[${index}]: [Nombre Plato: ${valorActual.nombrePlato} , Origen: ${valorActual.origenPlato} " +
                            ", Region: ${valorActual.regionPlato}, Calificacion: ${valorActual.calificacionPlato}" +
                            ",Precio: ${valorActual.precioPlato}]")
                }
            if(listaPlato.size == 0)
                println("Esta vacia!!")
        }
        fun eliminarPlato(index: Int){
            if (listaPlato.size > 0){
                listaPlato.removeAt(index)
                println("Eliminado!!")
            }
        }
        fun updatePlato(i: Int){
            listaPlato.mapIndexed { index, Plato ->
                if(index == i){
                    Plato.nombrePlato = cargarString("Nombre del Plato Tipico")
                    Plato.origenPlato = cargarString("Origen del Plato Tipico")
                    Plato.regionPlato = cargarString("Region del Plato Tipico")
                    Plato.calificacionPlato = cargarString("Calificacion del Plato Tipico")
                    Plato.precioPlato = cargarDouble("Precio del Plato Tipico")
                }
                return@mapIndexed Plato
            }
        }
        fun actualizarPlato() {
            val ruta = "src/main/kotlin/Plato.txt"
            try {
                FileWriter(ruta, false).use { fw ->
                    BufferedWriter(fw).use { bw ->
                        PrintWriter(bw).use { out ->
                            listaPlato.forEachIndexed() { index, valorActual ->  out.println("Plato[${index}]: [Nombre Plato: ${valorActual.nombrePlato} , Origen: ${valorActual.origenPlato} " +
                                    ", Region: ${valorActual.regionPlato}, Calificacion: ${valorActual.calificacionPlato} " +
                                    " ,Precio: ${valorActual.precioPlato}]") }
                        }
                    }
                }
            } catch (e: IOException) {
                //exception handling left as an exercise for the reader
            }
        }
    }


}
class Ingrediente(
    var nombreIngrediente1: String,
    var nombreIngrediente2: String,
    var nombreIngrediente3: String,
    var nombreIngrediente4: String,
    var nombreIngrediente5: String, nombrePlato: String, origenPlato: String, regionPlato: String, calificacionPlato: String,
    precioPlato: Double,
):Plato(nombrePlato, origenPlato, regionPlato, calificacionPlato, precioPlato){
    companion object {
        val listaIngrediente: ArrayList<Ingrediente> = arrayListOf()
        fun crearIngrediente(IngredienteNueva:Ingrediente){
            listaIngrediente.add(IngredienteNueva)
            println("Ingrediente agregada!!")
        }
        fun leerIngrediente(){
            listaIngrediente
                .forEachIndexed() { index: Int, valorActual: Ingrediente ->
                    println("Ingrediente[${index}]: [Ingrediente 1 ${valorActual.nombreIngrediente1} , Ingrediente 2:${valorActual.nombreIngrediente2} " +
                            ",Ingrediente 3: ${valorActual.nombreIngrediente3}, Ingrediente 4: ${valorActual.nombreIngrediente4}" +
                            ", Ingrediente 5 ${valorActual.nombreIngrediente5}] <- Plato { Nombre de la Plato: ${valorActual.nombrePlato} , Origen: ${valorActual.origenPlato} " +
                            "Region: ${valorActual.regionPlato}, Calificacion: ${valorActual.calificacionPlato}" +
                            ", Precio: ${valorActual.precioPlato}} ")
                }
            if(listaIngrediente.size == 0)
                println("Esta vacia!!")
        }
        fun eliminarIngrediente(index: Int){
            if (listaPlato.size > 0){
                listaIngrediente.removeAt(index)
                println("Eliminado!!")
            }
        }
        fun updateIngrediente(i: Int){
            listaIngrediente.mapIndexed { index, Ingrediente ->
                if(index == i){
                    Plato.leerPlato()
                    println("Ingrese el indice las espcies para crear la Ingrediente:")
                    val indice = readLine()!!.toInt()
                    Ingrediente.nombreIngrediente1 = cargarString("Ingrediente 1")
                    Ingrediente.nombreIngrediente2 = cargarString("Ingrediente 2")
                    Ingrediente.nombreIngrediente3 = cargarString("Ingrediente 3")
                    Ingrediente.nombreIngrediente4 = cargarString("Ingrediente 4")
                    Ingrediente.nombreIngrediente5 = cargarString("Ingrediente 5")
                    Ingrediente.nombrePlato = Plato.listaPlato[indice].nombrePlato
                    Ingrediente.origenPlato = Plato.listaPlato[indice].origenPlato
                    Ingrediente.regionPlato = Plato.listaPlato[indice].regionPlato
                    Ingrediente.calificacionPlato = Plato.listaPlato[indice].calificacionPlato
                    Ingrediente.precioPlato = Plato.listaPlato[indice].precioPlato
                }
                return@mapIndexed Ingrediente
            }
        }
        fun actualizarIngrediente() {
            val ruta = "src/main/kotlin/Ingrediente.txt"
            try {
                FileWriter(ruta, false).use { fw ->
                    BufferedWriter(fw).use { bw ->
                        PrintWriter(bw).use { out ->
                            listaIngrediente.forEachIndexed() { index, valorActual ->  out.println("Ingrediente[${index}]: [Ingrediente 1 ${valorActual.nombreIngrediente1} , Ingrediente 2:${valorActual.nombreIngrediente2} " +
                                    ",Ingrediente 3: ${valorActual.nombreIngrediente3}, Ingrediente 4: ${valorActual.nombreIngrediente4}" +
                                    ", Ingrediente 5 ${valorActual.nombreIngrediente5}] <- Plato { Nombre del Plato Tipico: ${valorActual.nombrePlato} , Origen: ${valorActual.origenPlato} " +
                                    "Region: ${valorActual.regionPlato}, Calificacion: ${valorActual.calificacionPlato}" +
                                    ", Precio: ${valorActual.precioPlato}} ") }
                        }
                    }
                }
            } catch (e: IOException) {
                //exception handling left as an exercise for the reader
            }
        }
    }

}