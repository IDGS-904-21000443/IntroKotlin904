package com.example.introkotlin904.PalindromoApp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class ResultadoPalindromoActivity : AppCompatActivity() {

    private lateinit var resultado : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado_palindromo)

        resultado = findViewById(R.id.textViewResultado)

        var esPalindromo : Boolean = intent.getBooleanExtra("esPalindromo", false)
        var original : String = intent.extras?.getString("original").orEmpty()

        if (esPalindromo) {
            var limpia : String = intent.extras?.getString("limpia").orEmpty()
            var reversa : String = intent.extras?.getString("reversa").orEmpty()
            var consonantes : Int = intent.getIntExtra("consonantes", 0)
            val vocales = contarVocales(original)
            val vocalesTexto = vocales.entries.joinToString("\n") { "${it.key}: ${it.value}" }
            resultado.text = "Cadena de texto original: ${original}\n\n" +
                             "Cadena limpia: ${limpia}\n\n" +
                             "Cadena limpia al revés: ${reversa}\n\n" +
                             "Número de consonantes en la cadena: ${consonantes}\n\n" +
                             "Vocales contenidas en la cadena:\n ${vocalesTexto}"
        } else {
            resultado.text = "La cadena de texto: '${original}' no es palíndromo"
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun contarVocales(frase: String): Map<Char, Int> {
        val sinAcentos = quitarAcentos(frase)
        val resultado = mutableMapOf('a' to 0, 'e' to 0, 'i' to 0, 'o' to 0, 'u' to 0)
        for (ch in sinAcentos) {
            if (ch in resultado) {
                resultado[ch] = resultado[ch]!! + 1
            }
        }
        return resultado
    }

    fun quitarAcentos(texto: String): String {
        return texto
            .lowercase()
            .replace("á", "a")
            .replace("é", "e")
            .replace("í", "i")
            .replace("ó", "o")
            .replace("ú", "u")
            .replace("ñ", "n")
    }
}