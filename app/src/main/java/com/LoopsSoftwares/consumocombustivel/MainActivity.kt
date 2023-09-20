package com.LoopsSoftwares.consumocombustivel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.LoopsSoftwares.consumocombustivel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBtn.setOnClickListener {
            calculateConsumption()
        }
    }

    private fun calculateConsumption(){
        val kilometers = binding.kilometersEdit.text.toString().toFloatOrNull()
        val liters = binding.litersEdit.text.toString().toFloatOrNull()

        if (kilometers != null && liters != null){
            val consumption = kilometers/liters
            val consumptionResult = String.format("%.2f", consumption)

            binding.resultText.text = "Consumo médio: $consumptionResult"
        } else {
            binding.resultText.text = "Dados inválidos!"
        }
    }
}