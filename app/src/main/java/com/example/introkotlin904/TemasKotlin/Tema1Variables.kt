package com.example.introkotlin904.TemasKotlin

fun main() {
    println("Hola Mundo")

    // Definicion de variables (solo lectura, inmutable) val
    val a : Int = 4
    val b : Int = 8
    // Definicion de variables (mutable) var
    var c : Int = 10

    // Imprimir valor de variables
    println(a)
    println("El valor de  b es: ${b}")
    println("El valor de  c mas 2 es: ${c+2}")

    // operadores
    c = a + 2
    c += 8
    c -= 5
    c * 8
    c /= 2

    println("El valor actual de c es ${c}")

    val num1 : Int = 10
    var num2 : Int = 12
    num2 = 6
    var num4 : Float = 12.5f
    var num5 : Double = 12.5

    var nombre : String = "Carlos"
    var character : Char = 'a'

}