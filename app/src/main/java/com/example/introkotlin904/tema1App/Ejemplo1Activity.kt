package com.example.introkotlin904.tema1App

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class Ejemplo1Activity : AppCompatActivity() {
    private lateinit  var et1 : EditText
    private lateinit  var et2 : EditText
    private lateinit  var tv1 : TextView
    private lateinit var rdbGrupo : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)

        // tomar una variable del xml
        // en este caso le primer EditText
        et1 = findViewById<EditText>(R.id.et1)
        et2 = findViewById<EditText>(R.id.et2)
        tv1 = findViewById<TextView>(R.id.tv1)

        rdbGrupo = findViewById(R.id.radioGroup)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun definirOperacion (view: android.view.View) {
        if (et1.text.toString().isEmpty() || et2.text.toString().isEmpty()) {
            mostrarMensaje("Debes ingresar ambos números")
            return
        }
        var rdbSeleccionado = rdbGrupo.checkedRadioButtonId
        when(rdbSeleccionado) {
            -1 -> mostrarMensaje("No has seleccionado ninguna operacion")
            R.id.rdbSuma -> sumar()
            R.id.rdbResta -> restar()
            R.id.rdbDividir -> dividir()
            R.id.rdbMultiplicar -> multiplicar()
        }
    }

    fun mostrarMensaje(msj : String) {
        tv1.text = msj
    }

    fun sumar() {
        val num1 = et1.text.toString().toFloat()
        val num2 = et2.text.toString().toFloat()
        val resultado : Float = num1 + num2
        tv1.text = resultado.toString()
    }

    fun restar() {
        val num1 = et1.text.toString().toFloat()
        val num2 = et2.text.toString().toFloat()
        val resultado : Float = num1 - num2
        tv1.text = resultado.toString()
    }

    fun dividir() {
        val num1 = et1.text.toString().toFloat()
        val num2 = et2.text.toString().toFloat()
        val resultado : Float = num1 / num2
        tv1.text = resultado.toString()
    }

    fun multiplicar() {
        val num1 = et1.text.toString().toFloat()
        val num2 = et2.text.toString().toFloat()
        val resultado : Float = num1 * num2
        tv1.text = resultado.toString()
    }
}