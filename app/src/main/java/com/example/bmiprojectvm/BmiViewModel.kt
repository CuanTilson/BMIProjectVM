package com.example.bmiprojectvm

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import java.text.DecimalFormat

class BmiViewModel : ViewModel() {

    var heightInput by mutableStateOf("")
        private set

    var weightInput by mutableStateOf("")
        private set

    // Computed property for BMI
    val bmi: String
        get() {
            val height = heightInput.toFloatOrNull() ?: 0.0f
            val weight = weightInput.toFloatOrNull() ?: 0.0f
            return if (height > 0 && weight > 0) {
                DecimalFormat("0.00").format(weight / (height * height))
            } else {
                "0.00"
            }
        }

    fun onHeightChange(newHeight: String) {
        heightInput = newHeight.replace(',', '.')
    }

    fun onWeightChange(newWeight: String) {
        weightInput = newWeight.replace(',', '.')
    }
}
