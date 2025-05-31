package com.example.introkotlin904.diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class Ventana1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana1)

        // variables de la vista
        var btnCapturar : Button = findViewById(R.id.btnCapturar)
        var btnBuscar : Button = findViewById(R.id.btnBuscar)

        // Asignar eventos a botones
        btnCapturar.setOnClickListener {
            var intent = Intent(this, Ventana2Activity::class.java)
            startActivity(intent)
        }

        btnBuscar.setOnClickListener {
            var intent = Intent(this, Ventana3Activity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}