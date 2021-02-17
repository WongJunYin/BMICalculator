package com.example.bmi_calculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMIActivity : AppCompatActivity() {

    private var bmiIndex : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)

        val personName = intent?.getStringExtra("personName")

        val textView = findViewById<TextView>(R.id.welcomeName)
        textView.setText(personName)

        if (savedInstanceState != null) {
            bmiIndex = savedInstanceState.getDouble("bmiIndex")

            if (bmiIndex != 0.0) {
                val textView = findViewById<TextView>(R.id.statusBar)
                textView.setText(getStatus())
            }
        }
        val btnCalculator = findViewById<View>(R.id.btnCalculate)

        btnCalculator.setOnClickListener()
        {
            val weight = findViewById<TextView>(R.id.weightInput).text.toString()
            val height = findViewById<TextView>(R.id.heightInput).text.toString()
            val tvStatus = findViewById<TextView>(R.id.statusBar)
            bmiIndex = weight.toDouble() / (height.toDouble() * height.toDouble())

            tvStatus.setText(getStatus())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmiIndex", bmiIndex)
    }

    private fun getStatus():String
    {
        if (bmiIndex < 18.5)
            return "Underweight"
        else if(bmiIndex <= 24.9)
            return "Normal weight"
        else if (bmiIndex <= 29.9)
            return "overweight"
        else if(bmiIndex <= 34.9)
            return "Obesity Class I"
        else if(bmiIndex <= 39.9)
            return "Obesity Class II"
        else
            return "Obesity Class III"

    }
}