package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PDM23","No onCreate, $percentual")

        val btCalc: Button = findViewById(R.id.btCalcular)
        val gasolina: EditText = findViewById(R.id.edGasolina)
        val alcool: EditText = findViewById(R.id.edAlcool)
        val resultText: TextView = findViewById(R.id.result)

        btCalc.setOnClickListener(View.OnClickListener {
            resultText.setText("")
            if (gasolina.text.isNotEmpty() and alcool.text.isNotEmpty()) {
                var gasPrice: Double = gasolina.text.toString().toDouble()
                var etanolPrice: Double = alcool.text.toString().toDouble()
                if(etanolPrice <= percentual*gasPrice) {
                    resultText.setText("Álcool vale a pena!")
                } else {
                    resultText.setText("Álcool NÃO vale a pena!")
                }
            } else {
                resultText.setText("Insira valores válidos")
            }
        })

        val swPercent: Switch = findViewById(R.id.swPercentual)
        swPercent.setOnClickListener  {
            percentual = if (percentual == 0.75) {
                0.7
            } else {
                0.75
            }
        }
    }
override fun onResume(){
    super.onResume()
    Log.d("PDM23","No onResume, $percentual")
}
override fun onStart(){
    super.onStart()
    Log.d("PDM23","No onResume")
}
override fun onPause(){
    super.onPause()
    Log.d("PDM23","No onResume")
}
override fun onStop(){
    super.onStop()
    Log.d("PDM23","No onResume")
}
override fun onDestroy(){
    super.onDestroy()
    Log.d("PDM23","No onResume")
}
}