package com.example.introkotlin904.TemasKotlin

import org.w3c.dom.Document

fun main() {
    mostrarMenu()
}

fun mostrarMenu() {
    while (true) {
        println("Operaciones basicas")
        println("1. Sumar")
        println("2. Restar")
        println("3. Dividir")
        println("4. Multiplicar")
        println("5. Salir")

        var opcion: Int = readln().toInt()

        if (opcion == 5) {
            println("Saliendo del sistema")
            break
        }
        if (!listOf(1, 2, 3, 4, 5).contains(opcion)) {
            println("Opcion no valida, vuelve a intentarlo")
            continue
        }
        var n1: Double = pedirNumero()
        var n2: Double = pedirNumero()

        if (opcion == 3 && n2 == 0.0) {
            println("No se puede divir entre 0, vuelve a intentarlo")
            continue
        }
        when (opcion) {
            1 -> sumar(n1, n2)
            2 -> restar(n1, n2)
            3 -> dividir(n1, n2)
            4 -> multiplicar(n1, n2)
            else -> println("Opcion no valida, vuelve a intentarlo")
        }

        println()
    }
}

fun pedirNumero(): Double {
    println("Introduce el numero")
    var numero: Double = readln().toDouble()
    return numero
}

fun sumar(n1: Double, n2: Double) {
    println("La suma de ${n1} + ${n2} es ${n1 + n2}")
}

fun restar(n1: Double, n2: Double) {
    println("La resta de ${n1} - ${n2} es ${n1 - n2}")
}

fun dividir(n1: Double, n2: Double) {
    println("La división de ${n1} / ${n2} es ${n1 / n2}")
}

fun multiplicar(n1: Double, n2: Double) {
    println("La multiplicación de ${n1} * ${n2} es ${n1 * n2}")
}