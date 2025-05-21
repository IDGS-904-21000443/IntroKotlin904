package com.example.introkotlin904

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.cineAbdroid.CineAbdroid
import com.example.introkotlin904.tema1App.Ejemplo1Activity
import com.example.introkotlin904.tema2App.Ejemplo2Activity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        val btnAccion : Button = findViewById(R.id.btnAccion)
        val btnAccion2 : Button = findViewById(R.id.btnAccion2)
        val btnAccion3 : Button = findViewById(R.id.btnAccion3)

        btnAccion.setOnClickListener { this.navegaAEjemplo1() }
        btnAccion2.setOnClickListener { navegaACinepolis() }
        btnAccion3.setOnClickListener { navegaAEjemplo2() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun navegaAEjemplo1() {
        val intent = Intent(this, Ejemplo1Activity::class.java)
        startActivity(intent)
    }

    fun navegaAEjemplo2() {
        val intent = Intent(this, Ejemplo2Activity::class.java)
        startActivity(intent)
    }

    fun navegaACinepolis() {
        val intent = Intent(this, CineAbdroid::class.java)
        startActivity(intent)
    }
}