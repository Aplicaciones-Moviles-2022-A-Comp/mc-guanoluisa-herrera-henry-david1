package com.example.examenprimerbimestre

class BBaseDatosMemoria {
    companion object{
        val arregloBEspecie = arrayListOf<BPlato>()
        val arregloBRaza = arrayListOf<BRaza>()
        init {
            arregloBEspecie
                .add(
                    BPlato("Encebollado", 2.50, "Costa", "Guayaquil","Sopa picante")
                )
            arregloBEspecie
                .add(
                    BPlato("Hornado", 3.00, "Sierra", "Pichincha", "Carne de cerdo")
                )
            arregloBEspecie
                .add(
                    BPlato("Yapingacho", 3.50, "Sierra", "Cotopaxi", "Tortillas de papa")
                )
        }
    }
}