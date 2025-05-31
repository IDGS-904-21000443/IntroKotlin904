package com.example.introkotlin904.diccionario

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

class Ventana2Activity : AppCompatActivity() {
    private val filename = "diccionario.txt"

    lateinit var btnRegresar1 : Button
    lateinit var btnGuardarPal : Button
    lateinit var txtResultado : TextView
    lateinit var txtIngles : EditText
    lateinit var txtEspanol : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana2)

        // Variables
        btnRegresar1 = findViewById(R.id.btnRegresar1)
        btnGuardarPal = findViewById(R.id.btnGuardarPal)
        txtResultado = findViewById(R.id.txtResultadoPal)
        txtIngles = findViewById(R.id.txtIngles)
        txtEspanol = findViewById(R.id.txtEspanol)

        // Asignar eventos
        btnRegresar1.setOnClickListener {
            var intent = Intent(this, Ventana1Activity::class.java)
            startActivity(intent)
        }

        btnGuardarPal.setOnClickListener {
            var txtEspanol : String = txtEspanol.text.toString().trim()
            var txtIngles : String = txtIngles.text.toString().trim()
            if(!validarVacios(txtEspanol, txtIngles)) {
                txtResultado.text = "Por favor indica el par de palabaras por favor"
            } else {
                guardarPalabras(txtEspanol, txtIngles)
                txtResultado.text = "Palabras guardadas con exito"
                this.txtEspanol.text.clear()
                this.txtIngles.text.clear()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun validarVacios(espanol : String, ingles : String) : Boolean {
        if (espanol.equals("") || ingles.equals(""))return false
        return true
    }

    fun guardarPalabras(espanol: String, ingles: String) {
        var definicion = espanol + "," + ingles + "\n"
        try {
            openFileOutput(filename, MODE_APPEND).use {
                it.write(definicion.toByteArray())
            }
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }
}