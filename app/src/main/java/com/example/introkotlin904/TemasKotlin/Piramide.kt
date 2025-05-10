package com.example.introkotlin904.TemasKotlin

fun main () {
    while (true) {
        println("Introduce el numero para el nivel de la piramide")
        var nivel : Int = readln().toInt()
        if (nivel == 0) {
            println("Saliendo del sistema")
            break
        }
        dibujarPiramide(nivel)
    }

}

fun dibujarPiramide(nivelFilas : Int) {
    var contadorNivel : Int = 1
    var contadorEspacios : Int = nivelFilas - 1

    do {
        if (contadorNivel != nivelFilas) {
            do {
                print(" ")
                contadorEspacios--
            }while (contadorEspacios >= 1)
        }
        contadorEspacios = nivelFilas - contadorNivel - 1

        var contadorCaracter : Int = 1
        do {
            print("* ")
            contadorCaracter++
        } while (contadorCaracter <= contadorNivel)

        contadorNivel++
        println()
    } while (contadorNivel <= nivelFilas)
}
//fun dibujarEscalera(nivel : Int) {
//    var contador : Int = 1
//    // para manejar el renglon
//    do {
//        // Para manejar la impresion
//        var i : Int = 0
//        var dibujo : String = ""
//        do {
//            dibujo += "+"
//            i++
//        } while (i+1 <= contador)
//        println(dibujo)
//        dibujo = ""
//        contador++
//    } while (contador <= nivel)
//}