package com.example.tempconvert

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tempconvert.ui.theme.TempconvertTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextTemperature = findViewById<EditText>(R.id.editTextTemperature)
        val buttonConvert = findViewById<Button>(R.id.buttonConvert)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonConvert.setOnClickListener {
            val inputText = editTextTemperature.text.toString()
            if (inputText.isNotEmpty()) {
                val temperature = inputText.toDouble()
                val result = convertTemperature(temperature)
                textViewResult.text = getString(R.string.result_format, result)
            }
        }
    }

    private fun convertTemperature(temperature: Double): Double {
        // Convert Celsius to Fahrenheit
        return temperature * 9 / 5 + 32

    }
}