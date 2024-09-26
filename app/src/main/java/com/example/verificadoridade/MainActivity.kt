package com.example.verificadoridade

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextIdade: EditText
    private lateinit var buttonVerificar: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextIdade = findViewById(R.id.editTextIdade)
        buttonVerificar = findViewById(R.id.buttonVerificar)
        textViewResultado = findViewById(R.id.textViewResultado)

        buttonVerificar.setOnClickListener { verificarIdade() }
    }

    private fun verificarIdade() {
        val idadeString = editTextIdade.text.toString().trim()

        when {
            idadeString.isEmpty() -> {
                textViewResultado.text = "Por favor, preencha o campo de idade."
            }
            else -> {
                val idade = idadeString.toIntOrNull()
                if (idade != null) {
                    val mensagem = when {
                        idade < 18 -> "Você é menor de idade."
                        idade in 18..60 -> "Você está na meia idade."
                        else -> "Você é idoso."
                    }
                    textViewResultado.text = mensagem
                } else {
                    textViewResultado.text = "Por favor, insira uma idade válida."
                }
            }
        }
    }
}
