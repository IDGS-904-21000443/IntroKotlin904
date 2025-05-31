package com.example.introkotlin904.diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R
import java.io.FileNotFoundException

class Ventana3Activity : AppCompatActivity() {
    private val filename = "diccionario.txt"

    lateinit var rdgPalabras : RadioGroup
    lateinit var rdbEspanol : RadioButton
    lateinit var rdbIngles : RadioButton
    lateinit var txtBuscarPal : EditText
    lateinit var btnBuscarPal : Button
    lateinit var txtBuscarRes : TextView
    lateinit var btnRegresar2 : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana3)

        rdgPalabras = findViewById(R.id.rdgPalabras)
        rdbEspanol = findViewById(R.id.rdbEspanol)
        rdbIngles  = findViewById(R.id.rdbIngles)

        txtBuscarPal = findViewById(R.id.txtBuscarPal)
        btnBuscarPal = findViewById(R.id.btnBuscarPal)

        txtBuscarRes = findViewById(R.id.txtBuscarRes)

        btnRegresar2 = findViewById(R.id.btnRegresar2)

        btnBuscarPal.setOnClickListener {
            var palabra = txtBuscarPal.text.toString().trim()
            if (!validarVacio(palabra)) {
                txtBuscarRes.text = "Por favor indica la palabra a buscar"
            } else {
                definirBusqueda()
            }
        }

        btnRegresar2.setOnClickListener {
            var intent = Intent(this, Ventana1Activity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun definirBusqueda() {
        var rdbSeleccionado = rdgPalabras.checkedRadioButtonId
        when(rdbSeleccionado) {
            -1 -> this.txtBuscarRes.text = "No has seleccionado ninguna opción"
            R.id.rdbIngles -> buscarEspanol()
            R.id.rdbEspanol -> buscarIngles()
        }
    }

    fun buscarEspanol() {
        // esta en español
        var palabra = this.txtBuscarPal.text.toString().trim().lowercase()
        var completado = true

        try {
            openFileInput(filename).bufferedReader().useLines { lines ->
                for (line in lines) {
                    var pal_esp = line.substring(0, line.indexOf(',', 0)).lowercase()
                    if(pal_esp.equals(palabra)){
                        var pal_ing = line.substringAfter(",")
                        this.txtBuscarRes.text = "Palabra encontrada: " + pal_ing
                        completado = false
                        break
                    }
                }
                if(completado) this.txtBuscarRes.text = "Palabra no encontrada"
            }
        } catch (e: FileNotFoundException) {
            this.txtBuscarRes.text = "Archivo no creado"
        }
    }

    fun buscarIngles() {
        // esta en ingles
        var palabra = this.txtBuscarPal.text.toString().trim().lowercase()
        var completado = true

        try {
            openFileInput(filename).bufferedReader().useLines { lines ->
                for (line in lines) {
                    var pal_ing = line.substringAfter(",").lowercase()
                    if(pal_ing.equals(palabra)){
                        var pal_esp = line.substring(0, line.indexOf(',', 0))
                        this.txtBuscarRes.text = "Palabra encontrada: " + pal_esp
                        completado = false
                        break
                    }
                }
                if (completado) this.txtBuscarRes.text = "Palabra no encontrada"
            }
        } catch (e: FileNotFoundException) {
            this.txtBuscarRes.text = "Archivo no creado"
        }
    }

    fun validarVacio(palabra : String) : Boolean {
        if (palabra.equals("")) return false
        return true
    }
}