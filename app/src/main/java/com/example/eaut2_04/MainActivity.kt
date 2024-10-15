package com.example.eaut2_04

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Declaramos las variables para los elementos de la interfaz
    private var milesInput: EditText? = null
    private var feetInput: EditText? = null
    private var inchesInput: EditText? = null // Campos de texto para ingresar millas, pies y pulgadas
    private var resultText: TextView? = null // Campo de texto para mostrar el resultado
    private var convertButton: Button? = null // Botón para realizar la conversión

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Establecemos el layout principal (activity_main.xml)

        // Inicializamos los componentes de la interfaz con sus IDs del XML
        milesInput = findViewById(R.id.milesInput) // Campo de texto para millas
        feetInput = findViewById(R.id.feetInput) // Campo de texto para pies
        inchesInput = findViewById(R.id.inchesInput) // Campo de texto para pulgadas
        resultText = findViewById(R.id.resultText) // Texto donde se mostrará el resultado
        convertButton = findViewById(R.id.convertButton) // Botón para convertir

        // Configuramos la acción a realizar cuando se presiona el botón
        convertButton?.setOnClickListener {
            convertToMeters() // Llamamos al método para realizar la conversión
        }
    }

    // Método para convertir las unidades del sistema inglés (millas, pies y pulgadas) a metros
    private fun convertToMeters() {
        // Obtenemos los valores ingresados en los campos de texto y los convertimos a tipo double
        val miles = milesInput?.text?.toString()?.toDoubleOrNull() ?: 0.0 // Convertir millas a double
        val feet = feetInput?.text?.toString()?.toDoubleOrNull() ?: 0.0 // Convertir pies a double
        val inches = inchesInput?.text?.toString()?.toDoubleOrNull() ?: 0.0 // Convertir pulgadas a double

        // Realizamos la conversión según la fórmula dada:
        // M = 1609.344 * L (millas) + 0.3048 * F (pies) + 0.0254 * P (pulgadas)
        val meters = (miles * 1609.344) + (feet * 0.3048) + (inches * 0.0254)

        // Mostramos el resultado en el TextView, concatenando el valor calculado de metros
        resultText?.text = "Resultado en Metros: $meters"
    }
}
