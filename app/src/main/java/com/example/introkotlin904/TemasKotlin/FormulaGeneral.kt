package com.example.introkotlin904.TemasKotlin

import android.text.BoringLayout
import  kotlin.math.*

fun main() {
    while (true) {
        var a: Double = pedirNumero("a")

        if (a == 0.0) {
            println("No se pude dividir entre cero (valor de a), por lo tanto no es ecuacion cuadratica, intentalo de nuevo")
            continue
        }

        var b: Double = pedirNumero("b")
        var c: Double = pedirNumero("c")

        if (calcularDiscriminante(a, b, c) == false) {
            println("Los valores para a, b y c dan como resultado raices negativas, vuelve a intentarlo")
            continue
        }
        var x1: Double = (-b + Math.sqrt((Math.pow(b, 2.0) - 4 * a * c))) / (2 * a)
        var x2: Double = (-b - Math.sqrt((Math.pow(b, 2.0) - 4 * a * c))) / (2 * a)
        println("La solucion de x1 es: ${x1}")
        println("La solucion de x2 es: ${x2}")
        break
    }
}

fun pedirNumero(letra: String): Double {
    println("Ingresa el numero para el valor ${letra}:")
    return readln().toDouble()
}

fun calcularDiscriminante(a: Double, b: Double, c: Double): Boolean {
    var dis = Math.pow(b, 2.0) - 4 * a * c
    var resultado: Boolean = false
    if (dis >= 0) {
        resultado = true
    }
    return resultado
}