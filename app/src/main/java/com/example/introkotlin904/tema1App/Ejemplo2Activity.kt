package com.example.introkotlin904.tema1App

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class Ejemplo2Activity : AppCompatActivity() {
    private lateinit  var ett1 : EditText
    private lateinit  var ett2 : EditText
    private lateinit  var tvv1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo2)

        // tomar una variable del xml
        // en este caso le primer EditText
        ett1 = findViewById<EditText>(R.id.ett1)
        ett2 = findViewById<EditText>(R.id.ett2)
        tvv1 = findViewById<TextView>(R.id.tvv1)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun multiplicarSuma(view : android.view.View) {
        val num1 = ett1.text.toString().toInt()
        val num2 = ett2.text.toString().toInt()

        var resultado : String = ""
        var resultadoNum : Int = 0
        var contador = 1

        while (contador <= num2) {
            resultadoNum += num1
            resultado += num1.toString().plus("+")
            contador++
        }
        resultado = resultado.substring(0,resultado.length-1)
        tvv1.text = resultado + " = " + resultadoNum
    }
}