package com.example.examenprimerbimestre

class BBaseDatosMemoria {
    companion object{
        val arregloBPlato = arrayListOf<BPlato>()
        val arregloBIngrediente = arrayListOf<BIngrediente>()
        init {
            arregloBPlato
                .add(
                    BPlato("Encebollado", 2.50, "Costa", "Guayaquil","Sopa picante")
                )
            arregloBPlato
                .add(
                    BPlato("Hornado", 3.00, "Sierra", "Pichincha", "Carne de cerdo")
                )
            arregloBPlato
                .add(
                    BPlato("Yapingacho", 3.50, "Sierra", "Cotopaxi", "Tortillas de papa")
                )
        }
    }
}