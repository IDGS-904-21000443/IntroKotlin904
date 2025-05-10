package com.example.introkotlin904.TemasKotlin

fun main() {
    // Range -> ..
    // 1..4 = 1,2,3,4
    // 1..<4 = 1,2,3
    // 4 downTo 1 = 4,3,2,1
    // 1..5 step 2 = 1,3,5
    // 'a' .. 'f' = a,b,c,d,e,f

    for (n in 1..5) {
        println(n)
    }

    val frutas : List<String> = listOf("Mandarina","Platano", "Sandia")
    for (n in frutas) {
        println(n)
    }

    // While
    var numero = 0
    while (numero <= 5){
        println(numero)
        numero++
    }
}