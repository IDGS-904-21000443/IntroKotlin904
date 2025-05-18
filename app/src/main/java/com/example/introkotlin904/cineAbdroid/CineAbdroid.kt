package com.example.introkotlin904.cineAbdroid

import android.os.Bundle
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin904.R

class CineAbdroid : AppCompatActivity() {
    private lateinit var etNombre : EditText
    private lateinit var etCantidadCompradores : EditText
    private lateinit var etCantidadBoletos : EditText
    private lateinit var txtBoletosPagar : TextView
    private lateinit var txtPago : TextView
    private lateinit var rgTarjeta : RadioGroup

    private var minBoletos : Int = 7
    private var maxBoletos : Int = 0
    private var costoBoleto : Float = 12.00F
    private var boletos : Int = 1
    private var descuentoBol : Float = 0.00F
    private var descuentoTar : Float = 0.00F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cine_abdroid)

        etNombre = findViewById<EditText>(R.id.etNombre)
        etCantidadCompradores = findViewById<EditText>(R.id.etCantCompra)
        etCantidadBoletos = findViewById<EditText>(R.id.etCantBol)

        txtBoletosPagar = findViewById<TextView>(R.id.txtBoletosPagar)
        txtPago = findViewById(R.id.txtPago)

        rgTarjeta = findViewById<RadioGroup>(R.id.rgTarjeta)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun validarCampos() : Boolean {
        if (etNombre.text.toString().isEmpty()) {
            mostrarNotificacion("Nombre del cliente requrido")
            etNombre.requestFocus()
            return false
        }
        if (etCantidadCompradores.text.toString().isEmpty() || etCantidadCompradores.text.toString().equals("0")) {
            mostrarNotificacion("La cantidad de compradores debe ser mayor a 0")
            etCantidadCompradores.requestFocus()
            return false
        }
        if (etCantidadBoletos.text.toString().isEmpty() || etCantidadBoletos.text.toString().equals("0")) {
            mostrarNotificacion("La cantidad de boletos debe ser mayor a 0")
            etCantidadBoletos.requestFocus()
            return false
        }
        return true
    }

    fun validarCantBoletos() : Boolean {
        maxBoletos = minBoletos * etCantidadCompradores.text.toString().toInt()
        if (etCantidadBoletos.text.toString().toInt() > maxBoletos) {
            mostrarNotificacion("La cantidad de boletos no puede sobrepasar ${maxBoletos} por ser ${etCantidadCompradores.text} compradores")
            return false
        }
        return true
    }

    fun definirDescuentos() {
        if(etCantidadBoletos.text.toString().toInt() >= 6) descuentoBol = 0.15F
        var t =  etCantidadBoletos.text.toString().toInt()
        if(t >= 3 && t <= 5) descuentoBol = 0.10F

        var rdbSeleccionado = rgTarjeta.checkedRadioButtonId
        when(rdbSeleccionado) {
            -1 -> mostrarNotificacion("No has seleccionado si tiene tarjeta Cineco")
            R.id.rbSi -> descuentoTar = 0.10F
        }
    }

    fun mostrarNotificacion(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun quitarTexto(){
        txtPago.text = "$0"
        txtBoletosPagar.text = "Boletos a pagar: 0"
    }

    fun calcularPago (view : android.view.View){
        quitarTexto()
        if(!validarCampos()) return
        if(!validarCantBoletos()) return
        definirDescuentos()

        this.boletos = etCantidadBoletos.text.toString().toInt()
        val costoBase = costoBoleto * boletos

        val descuentoBoletos = costoBase * descuentoBol
        val descuentoTarjeta = costoBase * descuentoTar
        val total = costoBase - descuentoBoletos - descuentoTarjeta

        txtBoletosPagar.text = "Boletos a pagar: $boletos"
        txtPago.text = """
            Subtotal = $$costoBase
            Descuento boletos: $$descuentoBoletos
            Descuento Tarjeta: $${"%.2f".format(descuentoTarjeta.toDouble())}
            Total: $$total
        """.trimIndent()
    }
}