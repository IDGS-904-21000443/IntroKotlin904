package com.example.introkotlin904.TemasKotlin

fun main() {
    val d : Int
    val check : Boolean = true

    if (check) {
        d = 1
    } else {
        d = 2
    }

    println(d)

    val d2 = if (check) 1 else 2
    println(d2)

    println("-------------------------------------")
    println("Ingrese el sueldo del empleado: ")
    val sueldo : Double = readln().toDouble()
    if (sueldo > 3000) {
        println("Debe pagar impuestos")
    }

    // Hasta aquí nos quedamos

    val obj : String = "Hello"
    when (obj) {
        "1" -> println("Uno")
        "Hello" -> println("Dos")
        else -> println("No hay coincidencia")
    }
}