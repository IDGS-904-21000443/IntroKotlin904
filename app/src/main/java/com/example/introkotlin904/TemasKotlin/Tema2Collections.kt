package com.example.introkotlin904.TemasKotlin

/*
* Colecciones de datos:
* - List
* - MutableList
* - Set
* - MutableSet
* - Map
* - MutableMap
* */

/*
* // LISTAS
    // Una lista que es inmutable. no se puede modificar
    val readOnlyFiguras : List<String> = listOf("cuadrado", "triangulo", "circulo")
    print(readOnlyFiguras.toString())
    // Una lista que es mutable. sí se puede modificar
    var figuras : MutableList<String> = mutableListOf("cuadrado", "triangulo", "circulo")
    println(figuras.toString())

    // SET
    // Un set que no se puede modificar
    val frutas = setOf("Manzana", "Platano", "Naranja")
    // Un set que si se puede modificar
    var mutablefrutas = mutableSetOf("Manzana", "Platano", "Naranja")

    // MAP
    // Un map que no se puede modificar
    val coches = mapOf("Uno" to 1, "Dos" to 2, "Tres" to 3)
    println(coches.toString())
    // Un map que sí se puede modificar
    var mutableCoches = mutableMapOf("Uno" to 1, "Dos" to 2, "Tres" to 3)
    println(mutableCoches)
* */

fun main(){
    val readOnlyFiguras : List<String> = listOf("cuadrado", "triangulo", "circulo")
    println(readOnlyFiguras)
    println("La primera figura es: ${readOnlyFiguras[0]}")
    println("El primer elemento es: ${readOnlyFiguras.first()}")
    println("El numero de elementos es: ${readOnlyFiguras.count()} items")
    println("circulo: " in readOnlyFiguras)
    println(readOnlyFiguras)
    // readOnlyFiguras.add("pentagono")
    var figura : MutableList<String> = mutableListOf("cuadrado2", "triangulo2", "circulo2")
    println(figura)
    figura.add("pentagono2")
    println(figura)
    figura.remove("cuadrado2")
    println(figura)
}