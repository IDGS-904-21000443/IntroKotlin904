package com.example.introkotlin904.TemasKotlin

import kotlinx.coroutines.processNextEventInCurrentThread

class Usuario() {
    val materia : String = ""
}

class Usuario2(val id : Int, val nombre : String) {
    val materia : String = ""

    fun saludar() {
        println("Hola")
    }
}

fun main() {
    var alumno = Usuario()
    var alumno2 = Usuario2(1, "Jose")

    println("Alumno: " + alumno)
    println("Alumno2: " + alumno2.id)
    println("Alumno2: " + alumno2.nombre)
}