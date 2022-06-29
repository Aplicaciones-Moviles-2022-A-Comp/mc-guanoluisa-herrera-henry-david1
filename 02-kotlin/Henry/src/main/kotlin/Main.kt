import java.util.*

// Main.kt
fun main() {
    println("Hola mundo")
    // Tipos de variables

    // INMUTABLES (NO Re Asignar) =
    val inmutable: String = "Adrian";
    //inmutable = "Vicente"; // No se puede re asignar

    // MUTABLES (Re Asignar) =
    var mutable: String = "Vicente"
    mutable = "Adrian"

    // val > var

    //Sintaxis Duck typing

    val ejemploVariable = "Ejemplo"
    val edadEjemplo: Int = 12
    ejemploVariable.trim()

    // Variables primitivas
    val nombreProfesor: String = "Adrian Eguez"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'S'
    val mayorEdad: Boolean = true
    // Clases JAVA
    val fechaNacimiento: Date = Date()

    if (true) {

    } else {

    }
    // switch no existe
    val estadoCivilWhen = "S"

    when (estadoCivilWhen) {
        ("S") -> {
            println("acercarse")
        }
        "C" -> {
            println("alejarse")
        }
        "UN" -> println("hablar")
        else -> println("No reconnocido")
    }
    val coqueteo = if (estadoCivilWhen == "S") "SI" else "NO"
    imprimirNombre("Adrian")

    val sumaUno = Suma(1,2)
    val sumaDos = Suma(3,4)
    sumaUno.sumar()
    sumaDos.sumar()
    println(Suma.historialSumas)

    // ARREGLOS

    // Tipos de Arreglos

    // Arreglo Estatico
    val arregloEstatico: Array<Int> = arrayOf(1, 2, 3)
    println(arregloEstatico)

    // Arreglo Dinámicos
    val arregloDinamico: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    // OPERADORES -> Sirven para los arreglos estáticos y dinámicos


    // FOR EACH -> Unit
    // Iterar un arreglo

    val respuestaForEach: Unit = arregloDinamico
        .forEach {
                valorActual: Int ->
            println("Valor actual: ${valorActual}")
        }
    arregloDinamico
        .forEachIndexed { indice: Int, valorActual: Int ->
            println("Valor ${valorActual} Indice: ${indice}")
        }
    println(respuestaForEach)

    // MAP -> Muta el arreglo (Cambia el arreglo)
    // 1) Enviemos el nuevo valor de la iteracion
    // 2) Nos devuelve es un NUEVO ARREGLO con los valores modificados

    val respuestaMap: List<Double> = arregloDinamico
        .map { valorActual: Int ->
            return@map valorActual.toDouble() + 100.00
        }

    println(respuestaMap)


}

// void imprimirNombre(String nombre){}
// Unit == void
fun imprimirNombre(nombre: String): Unit {
    println("Nombre : ${nombre}")
}

fun calcularSueldo(
    sueldo: Double, // Requerido
    tasa: Double = 12.00, // Opcional (Defecto)
    bonoEspecial: Double? = null, // Opcional (Null) -> nullable
): Double {
    // String -> String?
    // Int -> Int?
    // Date -> Date?
    if (bonoEspecial == null) {
        return sueldo * (100 / tasa)
    } else {
        return sueldo * (100 / tasa) + bonoEspecial
    }
}


abstract class NumerosJava {
    protected val numeroUno: Int
    private val numeroDos: Int

    constructor(
        uno: Int,
        dos: Int
    ) { // Bloque codigo constructor
        this.numeroUno = uno
        this.numeroDos = dos
        println("Inicializado")
    }
}

abstract class Numeros( // Constructor Primario
    // uno: Int, // Parametro
    // public var uno: Int, // Propiedad de la clase publica
    // var uno: Int, // Propiedad de la clase publica
    protected val numeroUno: Int, // Propiedad de la clase protected
    protected val numeroDos: Int // Propiedad de la clase protected
    // private val numeroDos: Int // Propiedad de la clase private
) {
    init { // Bloque codigo constructor PRIMARIO
        // this.numeroUno // Propiedad de la clase, this es OPCIONAL
        // this.numeroDos // Propiedad de la clase, this es OPCIONAL
        numeroDos // Propiedad de la clase
        numeroUno // Propiedad de la clase
        println("Inicializado")
    }

}

class Suma( // Constructor Primario Suma
    uno: Int, // Parametro
    dos: Int // Parametro
) : Numeros(
    //  Super constructor Numeros
    uno,
    dos,
) {
    init { // Bloque constructor primario
        this.numeroUno
        this.numeroDos
    }

    constructor( //  Segundo constructor
        uno: Int?, // parametros
        dos: Int // parametros
    ) : this( // llamada constructor primario
        if (uno == null) 0 else uno,
        dos
    ) {
        // bloque codigo segundo constructor
    }

    constructor( //  Tercer constructor
        uno: Int, // parametros
        dos: Int? // parametros
    ) : this(
        // llamada constructor primario
        uno,
        if (dos == null) 0 else dos,
    ) {
        // bloque codigo tercer constructor
    }

    constructor( //  Cuarto constructor
        uno: Int?, // parametros
        dos: Int? // parametros
    ) : this(
        // llamada constructor primario
        if (uno == null) 0 else uno,
        if (dos == null) 0 else dos,
    ) {
        // bloque codigo cuarto constructor
    }

    fun sumar(): Int {
        // val total: Int = this.numeroUno + this.numeroDos;
        val total = numeroUno + numeroDos
        agregarHistorial(total)
        return total
    }

    companion object {
        val pi = 3.14
        fun elevarAlCuadrado(num: Int): Int {
            return num * num
        }
        val historialSumas = arrayListOf<Int>()
        fun agregarHistorial(valorNuevaSuma:Int){
            historialSumas.add(valorNuevaSuma)
        }
    }
}


/*
*
* Suma
*
* Suma.pi // 3.14
* Suma.elevarAlCuadrado(3) // 9
* a = new Suma()
*
*
* */








