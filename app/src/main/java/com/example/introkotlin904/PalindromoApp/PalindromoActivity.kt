package com.example.introkotlin904.PalindromoApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class PalindromoActivity : AppCompatActivity() {

    private lateinit var frase : EditText
    private lateinit var boton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_palindromo)

        frase = findViewById(R.id.editTextFrase)
        boton = findViewById(R.id.btnVerificar)

        boton.setOnClickListener {
            var texto = frase.text.toString()
            var esPal = revisarPalindromo(texto)

            var intent = Intent(this, ResultadoPalindromoActivity::class.java)
            intent.putExtra("esPalindromo", esPal)
            intent.putExtra("original", texto)

            if(esPal){
                var limpia = quitarAlfa(texto)
                intent.putExtra("limpia", limpia)
                intent.putExtra("reversa", limpia.reversed())
                intent.putExtra("consonantes", contarConsonantes(texto))
            }

            frase.text.clear()
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun revisarPalindromo(nombre : String) : Boolean {
        var limpio = quitarAcentos(nombre)
        limpio = quitarEspaciosAlfa(limpio)
        return limpio == limpio.reversed()
    }

    fun contarConsonantes(frase: String): Int {
        val sinAcentos = quitarAcentos(frase)
        var contador = 0
        for (i in sinAcentos.lowercase()) {
            if (i in 'a'..'z' && i !in listOf('a','e','i','o','u')) contador++
        }
        return contador
    }

    fun quitarAcentos(texto: String): String {
        return texto
            .lowercase()
            .replace("á", "a")
            .replace("é", "e")
            .replace("í", "i")
            .replace("ó", "o")
            .replace("ú", "u")
    }

    fun quitarEspaciosAlfa(texto: String): String {
        return texto
            .lowercase()
            .replace("[^a-z0-9]".toRegex(), "")
    }

    fun quitarAlfa(texto: String): String {
        var t = quitarAcentos(texto)
        return t
            .replace(regex = "[^a-z0-9 ]".toRegex(), replacement = "")
    }
}