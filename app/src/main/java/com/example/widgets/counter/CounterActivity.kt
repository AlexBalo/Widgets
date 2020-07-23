package com.example.widgets.counter

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.widgets.R

class CounterActivity : AppCompatActivity() {
    private lateinit var counterView: CounterView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        counterView = findViewById(R.id.counter)
        counterView.setup(256, 294)

        val resetButton = findViewById<Button>(R.id.reset)
        resetButton.setOnClickListener {
            counterView.reset()
        }

    }
}